package com.example.task15

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "contact",
    indices = [
        Index("phone", unique = true)
    ]
)
data class ContactDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String?,
    @ColumnInfo val phone: String?
) {
    fun toContact(): Contact = Contact(
        id = id,
        name = name,
        phone = phone
    )
}