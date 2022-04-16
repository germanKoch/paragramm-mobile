package com.paragramm.mobile_paragramm.presentation.conversation_details

import android.os.Bundle
import android.widget.ListView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.data.model.Message
import com.paragramm.mobile_paragramm.presentation.conversation_details.component.ConversationDetailsViewModel
import com.paragramm.mobile_paragramm.presentation.conversation_details.component.ConversationDetailsViewModelFactory
import com.paragramm.mobile_paragramm.presentation.conversation_details.component.adapter.MessageAdapter
import kotlinx.coroutines.runBlocking

class ConversationActivity : AppCompatActivity() {

    private val conversationDetailsViewModel: ConversationDetailsViewModel by viewModels {
        ConversationDetailsViewModelFactory(intent.getLongExtra(CONVERSATION_ID_KEY, 0L))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        val data = mutableListOf<Message>()
        val adapter = MessageAdapter(this, R.layout.adapter_message_layout, data)
        val messagesView = findViewById<ListView>(R.id.messages)
        messagesView.adapter = adapter

        conversationDetailsViewModel._conversation.observe(this) { newData ->
            data.addAll(newData.messages)
            adapter.notifyDataSetChanged()
        }
    }

    companion object {
        const val CONVERSATION_ID_KEY = "conversationId"
    }

}