package com.yuriyyg.noteapp.presentation.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {


    @Insert
    suspend fun insert(note: NotesDbModel)

    @Delete
    suspend fun delete(note: NotesDbModel)

    @Update
    suspend fun update(note: NotesDbModel)

    @Query("SELECT * FROM notesdbmodel")
    fun getAll() : LiveData<List<NotesDbModel>>


}