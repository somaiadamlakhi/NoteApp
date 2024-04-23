package com.startappz.noteapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_tbl")
data class Note @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo("note_title")
    val title: String,
    @ColumnInfo("note_description")
    val description: String,
    @ColumnInfo("note_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)
