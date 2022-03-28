package com.example.task15

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<NoteDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteDbEntity: NoteDbEntity)

    @Update
    fun update(noteDbEntity: NoteDbEntity)

    @Delete
    fun delete(noteDbEntity: NoteDbEntity)
}