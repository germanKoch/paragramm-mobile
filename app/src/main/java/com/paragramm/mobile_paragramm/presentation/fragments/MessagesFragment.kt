package com.paragramm.mobile_paragramm.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.paragramm.mobile_paragramm.data.model.Message
import com.paragramm.mobile_paragramm.presentation.conversation.component.ConversationDetailsViewModel
import com.paragramm.mobile_paragramm.presentation.conversation.component.ConversationDetailsViewModelFactory
import kotlin.properties.Delegates

import androidx.recyclerview.widget.RecyclerView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.presentation.conversation.component.adapter.MessageRecyclerAdapter


class MessagesFragment : Fragment() {

    private var conversationDetailsViewModel by Delegates.notNull<ConversationDetailsViewModel>()
    private var conversationId by Delegates.notNull<Long>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            conversationId = it.getLong(CONVERSATION_ID_KEY)
            conversationDetailsViewModel = ViewModelProvider(
                activity!!,
                ConversationDetailsViewModelFactory(conversationId)
            ).get(ConversationDetailsViewModel::class.java)
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
        val data = mutableListOf<Message>()
        val messageAdapter = MessageRecyclerAdapter(data)

        (view.findViewById(R.id.recycler_messages) as RecyclerView).apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = messageAdapter
        }

        conversationDetailsViewModel._conversation.observe(this) { newData ->
            data.addAll(newData.messages)
            //TODO: inefficient
            messageAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        const val CONVERSATION_ID_KEY = "conversation_id"
    }
}