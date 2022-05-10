package com.paragramm.mobile_paragramm.viewmodel.mediator

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.paragramm.mobile_paragramm.repository.database.ParagrammDatabase
import com.paragramm.mobile_paragramm.repository.model.Conversation
import com.paragramm.mobile_paragramm.repository.network.ConversationNetworkRepository
import com.paragramm.mobile_paragramm.repository.network.MessageNetworkRepository
import kotlinx.coroutines.coroutineScope
import retrofit2.HttpException
import java.io.IOException


//TODO: does not work withour null object
@ExperimentalPagingApi
class ConversationRemoteMediator : RemoteMediator<Int, Conversation>() {

    private val networkRepository = ConversationNetworkRepository()
    private val db = ParagrammDatabase.getDatabase()
    private val dbRepository = db.conversationDao()

    //TODO: refactor
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Conversation>
    ): MediatorResult {
        return try {
            when (loadType) {
                LoadType.PREPEND -> return MediatorResult.Success(true)
                LoadType.REFRESH -> {
                    db.withTransaction {
                        networkRepository.getAllConversations().subscribe(
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
                        networkRepository.getConversationsAfterLast(lastItem.id).subscribe(
                            {
                                dbRepository.insertAll(it)
                            }, {
                                Log.e("load", "Error during appending", it)
                            }
                    )
                }

                //TODO: get next Key and set tru if it last
                MediatorResult.Success(true)
            }
        }
    } catch (e: IOException)
    {
        MediatorResult.Error(e)
    } catch (e: HttpException)
    {
        MediatorResult.Error(e)
    }
}

}