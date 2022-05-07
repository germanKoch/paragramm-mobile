package com.paragramm.mobile_paragramm.data.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.data.model.Message
import com.paragramm.mobile_paragramm.data.repository.converter.ZonedDateTimeConverter
import com.paragramm.mobile_paragramm.data.repository.dao.ConversationDao
import com.paragramm.mobile_paragramm.data.repository.dao.MessageDao
import com.paragramm.mobile_paragramm.data.repository.database.migrations.Migrations

@Database(entities = [Conversation::class, Message::class], version = 2)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class ParagrammDatabase : RoomDatabase() {

    abstract fun conversationDao(): ConversationDao

    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: ParagrammDatabase? = null

        fun getDatabase(context: Context): ParagrammDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ParagrammDatabase::class.java,
                            "paragramm_database"
                        ).addMigrations(
                            Migrations.create_conversation_table_1_2,
                            Migrations.create_message_table_1_2
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

}