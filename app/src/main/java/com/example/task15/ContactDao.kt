package com.example.task15

import androidx.room.*

@Dao
interface ContactDao{
    @Query("SELECT * FROM contact")
    fun getAll(): List<ContactDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contactDbEntity: ContactDbEntity)

    @Update
    fun update(contactDbEntity: ContactDbEntity)

    @Delete
    fun delete(contactDbEntity: ContactDbEntity)
}