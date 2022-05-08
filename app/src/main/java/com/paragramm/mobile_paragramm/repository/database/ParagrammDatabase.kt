package com.paragramm.mobile_paragramm.repository.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.repository.model.Conversation
import com.paragramm.mobile_paragramm.repository.model.Message
import com.paragramm.mobile_paragramm.repository.database.converter.ZonedDateTimeConverter
import com.paragramm.mobile_paragramm.repository.database.dao.ConversationDao
import com.paragramm.mobile_paragramm.repository.database.dao.MessageDao
import com.paragramm.mobile_paragramm.repository.database.migrations.Migrations

@Database(entities = [Conversation::class, Message::class], version = 2)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class ParagrammDatabase : RoomDatabase() {

    abstract fun conversationDao(): ConversationDao

    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: ParagrammDatabase = Room.databaseBuilder(
            ParagrammApplication.context,
            ParagrammDatabase::class.java,
            "paragramm_database"
        ).addMigrations(
            Migrations.create_conversation_table_1_2,
            Migrations.create_message_table_1_2
        ).build()

        fun getDatabase(): ParagrammDatabase {
            return INSTANCE
        }
    }

}