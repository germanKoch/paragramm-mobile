package com.paragramm.mobile_paragramm.repository.database.converter

import androidx.room.TypeConverter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object ZonedDateTimeConverter {

    private val formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toZonedDateTime(value: String?): ZonedDateTime? {
        return value?.let { formatter.parse(it, ZonedDateTime::from) }
    }

    @TypeConverter
    @JvmStatic
    fun fromZonedDateTime(value: ZonedDateTime?): String? {
        return value?.format(formatter)
    }

}
