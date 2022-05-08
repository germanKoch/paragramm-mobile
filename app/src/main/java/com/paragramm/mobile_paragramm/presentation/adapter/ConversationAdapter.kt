package com.paragramm.mobile_paragramm.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.repository.model.Conversation

class ConversationAdapter(private val mContext: Context,
                          private val resource: Int,
                          conversations: MutableList<Conversation>):
    ArrayAdapter<Conversation>(mContext, 0, conversations) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val title = getItem(position)?.title
        val picture = getItem(position)?.picture

        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(resource, parent, false)

        view.findViewById<TextView>(R.id.picture).apply {
            text = picture
        }
        view.findViewById<TextView>(R.id.title).apply {
            text = title
        }

        return view
    }


}