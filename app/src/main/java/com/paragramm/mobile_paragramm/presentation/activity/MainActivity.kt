package com.paragramm.mobile_paragramm.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.paging.ExperimentalPagingApi
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.presentation.fragments.ConversationsFragment
import com.paragramm.mobile_paragramm.presentation.fragments.MessagesFragment

@ExperimentalPagingApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            replace<ConversationsFragment>(R.id.fragment_container_view)
        }
        //TODO: implement in better way
        findViewById<View>(R.id.back_button).setOnClickListener {
            when (supportFragmentManager.findFragmentById(R.id.fragment_container_view)) {
                is MessagesFragment -> {
                    supportFragmentManager.commit {
                        replace<ConversationsFragment>(R.id.fragment_container_view)
                    }
                }

                is ConversationsFragment -> {
                    //ignore
                }
            }
        }
    }

}