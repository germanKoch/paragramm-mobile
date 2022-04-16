package com.paragramm.mobile_paragramm.presentation.conversation

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.presentation.conversation.component.adapter.ConversationAdapter
import com.paragramm.mobile_paragramm.domain.auth.UserDetails
import com.paragramm.mobile_paragramm.presentation.conversation_details.ConversationActivity
import com.paragramm.mobile_paragramm.presentation.conversation.component.ConversationsViewModel
import com.paragramm.mobile_paragramm.presentation.conversation.component.ConversationsViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private val conversationsViewModel: ConversationsViewModel by viewModels {
        ConversationsViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val data = mutableListOf<Conversation>()
        val adapter = ConversationAdapter(this, R.layout.adapter_conversation_layout, data)
        findViewById<ListView>(R.id.conversations).apply {
            this.adapter = adapter
            this.setOnItemClickListener { adapter, view, position, id ->
                val item = data[position]
                Intent(this@MainActivity, ConversationActivity::class.java).apply {
                    putExtra(ConversationActivity.CONVERSATION_ID_KEY, item.id)
                    startActivity(this)
                }
            }
        }

        conversationsViewModel._conversations.observe(this) { newData ->
            data.addAll(newData)
            adapter.notifyDataSetChanged()
        }
    }

}