package com.yuriyyg.noteapp.presentation.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuriyyg.noteapp.presentation.data.NoteRepository
import com.yuriyyg.noteapp.presentation.data.NotesDbModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowNotesViewModel @Inject constructor( var repository: NoteRepository):ViewModel() {


    fun getAll() : LiveData<List<NotesDbModel>>{
        return repository.getAll()
    }

    fun delete(note: NotesDbModel){
        viewModelScope.launch {
             repository.delete(note)
        }

    }


}