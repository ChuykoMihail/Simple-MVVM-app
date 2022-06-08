package com.example.dicetest.data.util

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class IncidentUtil {

        companion object {
            fun formatUnixTime(dateString: String): String {
                val actual = OffsetDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME)
                val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss")
                return actual.format(formatter)
            }
        }
}