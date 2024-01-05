package com.yuriyyg.noteapp.presentation.data

import androidx.lifecycle.LiveData


class NoteRepository(private val notesDao: NotesDao) {


    suspend fun insert(note: NotesDbModel){
        notesDao.insert(note)
    }


    suspend fun delete(note: NotesDbModel){
        notesDao.delete(note)
    }

    fun getAll() : LiveData<List<NotesDbModel>>{
        return notesDao.getAll()
    }

}