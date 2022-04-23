package com.paragramm.mobile_paragramm.presentation.conversation.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.data.model.Message

class MessageAdapter(private val mContext: Context,
                     private val resource: Int,
                     messages: MutableList<Message>):
    ArrayAdapter<Message>(mContext, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val sender = getItem(position)?.senderId
        val message = getItem(position)?.text

        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(resource, parent, false)

        view.findViewById<TextView>(R.id.senderId).apply {
            text = message
        }
        view.findViewById<TextView>(R.id.message).apply {
            text = sender.toString()
        }

        return view
    }


}