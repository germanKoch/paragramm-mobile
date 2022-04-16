package com.paragramm.mobile_paragramm.data.repository.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migrations {

    companion object {
        val create_conversation_table_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE 'conversation' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'title' TEXT NOT NULL, 'picture' TEXT NOT NULL);")
            }
        }

        val create_message_table_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE 'message' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'conversationId' INTEGER NOT NULL, 'sender' TEXT NOT NULL, 'text' TEXT NOT NULL);")
            }
        }
    }

}