package com.paragramm.mobile_paragramm.presentation.conversation.component.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.data.model.Message

class MessagePagedAdapter :
    PagingDataAdapter<Message, MessagePagedAdapter.ViewHolder>(DIFF_CALLBACK) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val message: TextView = view.findViewById(R.id.message)
        val senderId: TextView = view.findViewById(R.id.senderId)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = getItem(position)
        holder.message.text = message?.text
        holder.senderId.text = message?.senderId.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_layout, parent, false)
        return ViewHolder(view)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Message>() {
            override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem == newItem
            }

        }
    }

}