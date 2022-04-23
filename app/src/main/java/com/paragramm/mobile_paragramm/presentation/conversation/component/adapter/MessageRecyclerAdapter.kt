package com.paragramm.mobile_paragramm.presentation.conversation.component.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.data.model.Message

class MessageRecyclerAdapter(
    private val data: List<Message>
) : RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val message: TextView = view.findViewById(R.id.message)
        val senderId: TextView = view.findViewById(R.id.senderId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = data[position]
        holder.message.text = message.text
        holder.senderId.text = message.senderId.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

}