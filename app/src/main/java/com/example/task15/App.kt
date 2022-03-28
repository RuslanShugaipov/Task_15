package com.example.task15

import android.content.Context
import androidx.room.Room

class App {
    private lateinit var database: AppDatabase
    private lateinit var noteDao: NoteDao
    private lateinit var contactDao: ContactDao

    fun init(context: Context) {
        database = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "contact_notes.db")
            .allowMainThreadQueries()
            .build()

        noteDao = database.noteDao()
        contactDao = database.contactDao()
    }

    fun getDatabase(): AppDatabase {
        return database
    }

    fun setDatabase(database: AppDatabase) {
        this.database = database
    }

    fun getNoteDao(): NoteDao {
        return noteDao
    }

    fun getContactDao(): ContactDao {
        return contactDao
    }
}