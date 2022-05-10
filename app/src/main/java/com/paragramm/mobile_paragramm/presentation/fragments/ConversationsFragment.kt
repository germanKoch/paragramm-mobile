package com.paragramm.mobile_paragramm.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.RecyclerView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.presentation.adapter.ConversationAdapter
import com.paragramm.mobile_paragramm.viewmodel.ConversationsViewModel
import com.paragramm.mobile_paragramm.viewmodel.ConversationsViewModelFactory
import com.paragramm.mobile_paragramm.presentation.adapter.ConversationPagedAdapter
import com.paragramm.mobile_paragramm.repository.model.Conversation
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

@ExperimentalPagingApi
class ConversationsFragment : Fragment() {

    private var conversationsViewModel by Delegates.notNull<ConversationsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        conversationsViewModel = ViewModelProvider(
            activity!!,
            ConversationsViewModelFactory()
        )[ConversationsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_conversations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val conversationAdapter = ConversationPagedAdapter(
            object : ConversationPagedAdapter.OnConversationClickListener {
                override fun onClick(conversation: Conversation) {
                    val bundle = bundleOf(MessagesFragment.CONVERSATION_ID_KEY to conversation.id)
                    parentFragmentManager.commit {
                        replace<MessagesFragment>(R.id.fragment_container_view, args = bundle)
                    }
                }
            }
        )

        (view.findViewById(R.id.recycler_conversations) as RecyclerView).apply {
            adapter = conversationAdapter
        }

        lifecycleScope.launch {
            conversationsViewModel._conversations.collectLatest {
                conversationAdapter.submitData(it)
            }
        }

    }


}