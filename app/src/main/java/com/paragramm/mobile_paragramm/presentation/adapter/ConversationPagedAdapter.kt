package com.paragramm.mobile_paragramm.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.repository.model.Conversation
import com.paragramm.mobile_paragramm.repository.model.Message

class ConversationPagedAdapter(
    private val onClickListener: OnConversationClickListener
) : PagingDataAdapter<Conversation, ConversationPagedAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        val picture: TextView = view.findViewById(R.id.picture)
        val title: TextView = view.findViewById(R.id.title)

        override fun onClick(p0: View?) {
            getItem(absoluteAdapterPosition)?.let {
                onClickListener.onClick(it)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conversation = getItem(position)
        holder.picture.text = conversation?.picture
        holder.title.text = conversation?.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.conversation_layout, parent, false)
        return ViewHolder(view)
    }

    @FunctionalInterface
    interface OnConversationClickListener {

        fun onClick(conversation: Conversation)

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Conversation>() {
            override fun areItemsTheSame(oldItem: Conversation, newItem: Conversation): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Conversation, newItem: Conversation): Boolean {
                return oldItem == newItem
            }

        }
    }

}