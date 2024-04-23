package com.startappz.noteapp

import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.format(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        this.format(DateTimeFormatter.ofPattern("EEE, d MMM"))
    } else {
        this.toString()
    }
}