package com.example.task15

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "note",
)
data class NoteDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val text: String?
) {
    fun toNote(): Note = Note(
        id = id,
        text = text
    )
}