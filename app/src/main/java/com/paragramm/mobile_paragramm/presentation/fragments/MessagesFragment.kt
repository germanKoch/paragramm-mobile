package com.paragramm.mobile_paragramm.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.RecyclerView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.presentation.conversation.component.ConversationDetailsViewModelFactory
import com.paragramm.mobile_paragramm.presentation.conversation.component.MessagesViewModel
import com.paragramm.mobile_paragramm.presentation.conversation.component.adapter.MessagePagedAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

@ExperimentalPagingApi
class MessagesFragment : Fragment() {

    private var conversationDetailsViewModel by Delegates.notNull<MessagesViewModel>()
    private var conversationId by Delegates.notNull<Long>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            conversationId = it.getLong(CONVERSATION_ID_KEY)
            conversationDetailsViewModel = ViewModelProvider(
                activity!!,
                ConversationDetailsViewModelFactory(conversationId)
            ).get(MessagesViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val messageAdapter = MessagePagedAdapter()

        (view.findViewById(R.id.recycler_messages) as RecyclerView).apply {
            adapter = messageAdapter
        }

        lifecycleScope.launch {
            conversationDetailsViewModel._messages.collectLatest {
                messageAdapter.submitData(it)
            }
        }
    }

    companion object {
        const val CONVERSATION_ID_KEY = "conversation_id"
    }
}