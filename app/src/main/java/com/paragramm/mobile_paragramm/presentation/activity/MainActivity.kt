package com.paragramm.mobile_paragramm.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.paging.ExperimentalPagingApi
import com.paragramm.mobile_paragramm.R
import com.paragramm.mobile_paragramm.presentation.fragments.ConversationsFragment


@ExperimentalPagingApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            replace<ConversationsFragment>(R.id.fragment_container_view)
        }
    }

}