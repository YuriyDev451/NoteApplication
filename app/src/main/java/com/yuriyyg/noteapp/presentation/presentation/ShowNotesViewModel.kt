package com.yuriyyg.noteapp.presentation.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yuriyyg.noteapp.presentation.data.NoteRepository
import com.yuriyyg.noteapp.presentation.data.NotesDbModel

class ShowNotesViewModel:ViewModel() {

    lateinit var repository: NoteRepository


    fun getAll() : LiveData<List<NotesDbModel>>{
        return repository.getAll()
    }
}