package com.paragramm.mobile_paragramm.repository.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migrations {

    companion object {
        val create_conversation_table_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE 'conversation' ('id' INTEGER PRIMARY KEY, 'title' TEXT NOT NULL, 'picture' TEXT NOT NULL, 'creationDate' TEXT NOT NULL);")
            }
        }

        val create_message_table_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE 'message' ('id' INTEGER PRIMARY KEY, 'conversationId' INTEGER NOT NULL, 'senderId' INTEGER NOT NULL, 'text' TEXT NOT NULL, 'creationDate' TEXT NOT NULL);")
            }
        }
    }

}