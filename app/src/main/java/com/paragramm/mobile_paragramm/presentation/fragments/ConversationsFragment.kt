package com.paragramm.mobile_paragramm.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.presentation.conversation.component.ConversationsViewModel
import com.paragramm.mobile_paragramm.presentation.conversation.component.ConversationsViewModelFactory
import com.paragramm.mobile_paragramm.presentation.conversation.component.adapter.ConversationAdapter
import kotlin.properties.Delegates

class ConversationsFragment : Fragment() {

    private var conversationsViewModel by Delegates.notNull<ConversationsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        conversationsViewModel = ViewModelProvider(
            activity!!,
            ConversationsViewModelFactory()
        ).get(ConversationsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_conversations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = mutableListOf<Conversation>()
        val adapter = ConversationAdapter(activity!!.applicationContext, R.layout.conversation_layout, data)
        view.findViewById<ListView>(R.id.conversations_list).apply {
            this.adapter = adapter
            this.setOnItemClickListener { adapter, view, position, id ->
                val item = data[position]
                val bundle = bundleOf(MessagesFragment.CONVERSATION_ID_KEY to item.id!!)
                parentFragmentManager.commit {
                    replace<MessagesFragment>(R.id.fragment_container_view, args = bundle)
                }
            }
        }

        conversationsViewModel._conversations.observe(this) { newData ->
            data.addAll(newData)
            adapter.notifyDataSetChanged()
        }
    }


}