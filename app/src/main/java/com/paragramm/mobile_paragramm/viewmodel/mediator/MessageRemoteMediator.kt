package com.paragramm.mobile_paragramm.viewmodel.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
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
class MessageRemoteMediator : RemoteMediator<Int, Message>() {

    private val networkRepository = MessageNetworkRepository()
    private val dbRepository = ParagrammDatabase.getDatabase().messageDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Message>
    ): MediatorResult {
        return try {
            // The network load method takes an optional after=<user.id>
            // parameter. For every page after the first, pass the last user
            // ID to let it continue from where it left off. For REFRESH,
            // pass null to load the first page.
            when (loadType) {
                LoadType.REFRESH -> return MediatorResult.Success(endOfPaginationReached = false)
                // In this example, you never need to prepend, since REFRESH
                // will always load the first page in the list. Immediately
                // return, reporting end of pagination.
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    //TODO: change
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    networkRepository.getMessagesAfter(lastItem.conversationId, lastItem.id)
                        .doOnEach {
                            if (it.value != null) {
                                dbRepository.insertAll(it.value!!)
                            }
                        }

                    //TODO: get next Key and set tru if it last
                    MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                }
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}