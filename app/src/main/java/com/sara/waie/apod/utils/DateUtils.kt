package com.sara.waie.apod.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

        /**
         * This method return today's date in "yyyy-MM-dd" format
         */
        fun todayDate(): String {
            val calendar = Calendar.getInstance()
            simpleDateFormat.timeZone = TimeZone.getTimeZone("EST")
            return simpleDateFormat.format(calendar.time)
//           return "2022-03-03"
        }
    }
}