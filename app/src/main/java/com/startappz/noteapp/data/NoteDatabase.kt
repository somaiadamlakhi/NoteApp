package com.startappz.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.startappz.noteapp.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDAO() : NoteDatabaseDao
}