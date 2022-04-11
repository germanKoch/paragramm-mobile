package com.paragramm.mobile_paragramm.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.activity.adapter.ConversationAdapter
import com.paragramm.mobile_paragramm.auth.UserDetails
import com.paragramm.mobile_paragramm.model.Conversation
import com.paragramm.mobile_paragramm.service.ConversationService
import javax.inject.Inject

class MainActivity : InjectableActivity() {

    @Inject
    lateinit var conversationService: ConversationService

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

        data.addAll(conversationService.getAll(UserDetails.USER_ID))
        adapter.notifyDataSetChanged()
    }

    override fun inject() {
        (applicationContext as ParagrammApplication).appComponent.inject(this)
    }

}