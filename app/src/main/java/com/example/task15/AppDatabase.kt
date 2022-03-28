package com.example.task15

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        ContactDbEntity::class,
        NoteDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun contactDao(): ContactDao
}