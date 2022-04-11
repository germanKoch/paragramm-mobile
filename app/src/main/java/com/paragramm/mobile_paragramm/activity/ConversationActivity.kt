package com.paragramm.mobile_paragramm.activity

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.paragramm.mobile_paragramm.DaggerApplicationGraph
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.activity.adapter.MessageAdapter
import com.paragramm.mobile_paragramm.auth.UserDetails
import com.paragramm.mobile_paragramm.model.Message
import com.paragramm.mobile_paragramm.service.ConversationDetailsService
import javax.inject.Inject

class ConversationActivity : InjectableActivity() {

    @Inject
    lateinit var conversationService: ConversationDetailsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        val conversationId = intent.getLongExtra(CONVERSATION_ID_KEY, 0L)
        val conversation = conversationService.getById(conversationId, UserDetails.USER_ID)

        val data = mutableListOf<Message>()
        val adapter = MessageAdapter(this, R.layout.adapter_message_layout, data)
        val messagesView = findViewById<ListView>(R.id.messages)
        messagesView.adapter = adapter

        data.addAll(conversation.messages)
        adapter.notifyDataSetChanged()
    }

    override fun inject() {
        (applicationContext as ParagrammApplication).appComponent.inject(this)
    }

    companion object {
        val CONVERSATION_ID_KEY = "conversationId"
    }

}