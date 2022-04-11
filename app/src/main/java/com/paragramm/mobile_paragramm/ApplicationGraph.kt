package com.paragramm.mobile_paragramm

import com.paragramm.mobile_paragramm.activity.ConversationActivity
import com.paragramm.mobile_paragramm.activity.MainActivity
import com.paragramm.mobile_paragramm.service.ConversationDetailsService
import com.paragramm.mobile_paragramm.service.ConversationService
import dagger.Component

@Component
interface ApplicationGraph {

    fun getConversationService(): ConversationService

    fun getConversationDetailsService(): ConversationDetailsService

    fun inject(activity: MainActivity)

    fun inject(activity: ConversationActivity)
}