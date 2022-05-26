package com.example.dicetest.data.util

import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class IncidentUtil {
        companion object {
            fun formatUnixTime(timeInSeconds: Long, pattern: String): String {
                val simpleDateFormat = SimpleDateFormat(pattern, Locale.US)
                val value = simpleDateFormat.format(Date(timeInSeconds * 1000))
                return value
            }

        }
}