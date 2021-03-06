package com.paragramm.mobile_paragramm.viewmodel.mediator

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.paragramm.mobile_paragramm.config.LOGIN
import com.paragramm.mobile_paragramm.config.PASSWORD
import com.paragramm.mobile_paragramm.repository.model.Message
import com.paragramm.mobile_paragramm.repository.network.retrofit.AuthClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.MessagesClient
import com.paragramm.mobile_paragramm.repository.database.ParagrammDatabase
import com.paragramm.mobile_paragramm.repository.network.MessageNetworkRepository
import com.paragramm.mobile_paragramm.repository.network.resource.AuthRequest
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class MessageRemoteMediator(
    val conversationId: Long
) : RemoteMediator<Int, Message>() {

    private val networkRepository = MessageNetworkRepository()
    private val db = ParagrammDatabase.getDatabase()
    private val dbRepository = db.messageDao()

    //TODO: load from end to start
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Message>
    ): MediatorResult {
        //TODO: refactor
        return try {
            when (loadType) {
                LoadType.PREPEND -> return MediatorResult.Success(true)
                LoadType.REFRESH -> {
                    db.withTransaction {
                        networkRepository.getAllMessages(conversationId).subscribe(
                            {
                                dbRepository.insertAll(it)
                            }, {
                                Log.e("load", "Error during refreshing", it)
                            }
                        )
                    }
                    return MediatorResult.Success(false)
                }
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull() ?: return MediatorResult.Success(true)

                    db.withTransaction {
                        networkRepository.getMessagesAfter(lastItem.conversationId, lastItem.id)
                            .subscribe(
                                {
                                    dbRepository.insertAll(it)
                                }, {
                                    Log.e("load", "Error during appending", it)
                                }
                            )
                    }
                    MediatorResult.Success(true)
                }
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}