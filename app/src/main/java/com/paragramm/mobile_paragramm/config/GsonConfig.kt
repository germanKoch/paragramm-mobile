package com.paragramm.mobile_paragramm.config

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

val ZONED_DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz")

object ZonedDateTypeAdapter: TypeAdapter<ZonedDateTime>() {
    override fun write(out: JsonWriter, value: ZonedDateTime?) {
        out.value(
            value?.let {
                ZONED_DATE_TIME_FORMATTER.format(value)
            }
        )
    }

    override fun read(input: JsonReader): ZonedDateTime {
        return ZONED_DATE_TIME_FORMATTER.parse(input.nextString(), ZonedDateTime::from)
    }

}