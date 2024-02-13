package com.yuriyyg.noteapp.presentation.data

import androidx.lifecycle.LiveData
import javax.inject.Inject


 interface NoteRepositoryInterface

class NoteRepository @Inject constructor(private val notesDao: NotesDao): NoteRepositoryInterface {


    suspend fun insert(note: NotesDbModel){
        notesDao.insert(note)
    }


    suspend fun delete(note: NotesDbModel){
        notesDao.delete(note)
    }

    suspend fun update(note: NotesDbModel){
        notesDao.update(note)
    }

    fun getAll() : LiveData<List<NotesDbModel>>{
        return notesDao.getAll()
    }

}