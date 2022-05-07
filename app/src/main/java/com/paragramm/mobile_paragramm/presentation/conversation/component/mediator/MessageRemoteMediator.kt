package com.paragramm.mobile_paragramm.presentation.conversation.component.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.paragramm.mobile_paragramm.config.LOGIN
import com.paragramm.mobile_paragramm.config.PASSWORD
import com.paragramm.mobile_paragramm.data.model.Message
import com.paragramm.mobile_paragramm.data.repository.client.AuthService
import com.paragramm.mobile_paragramm.data.repository.client.MessageService
import com.paragramm.mobile_paragramm.data.repository.database.ParagrammDatabase
import com.paragramm.mobile_paragramm.data.repository.resource.AuthRequest
import retrofit2.HttpException
import java.io.IOException
import kotlin.concurrent.thread

@ExperimentalPagingApi
class MessageRemoteMediator(
    val authService: AuthService,
    val messageService: MessageService,
    val db: ParagrammDatabase
) : RemoteMediator<Int, Message>() {

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
                    thread {
                        val token = authService.auth(
                            AuthRequest(LOGIN, PASSWORD)
                        ).execute().body()!!.token

                        val messages = messageService.getMessagesAfterLast(
                            token,
                            lastItem.conversationId,
                            lastItem.id
                        ).execute().body()!!

                        db.messageDao().insertAll(messages)
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