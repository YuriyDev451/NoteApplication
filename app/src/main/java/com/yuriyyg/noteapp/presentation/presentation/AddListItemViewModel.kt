package com.yuriyyg.noteapp.presentation.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuriyyg.noteapp.presentation.data.NoteRepository
import com.yuriyyg.noteapp.presentation.data.NotesDbModel
import kotlinx.coroutines.launch

class AddListItemViewModel: ViewModel() {
    lateinit var repository: NoteRepository

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    fun insert(note: NotesDbModel){
        viewModelScope.launch {
            repository.insert(note)
        }

    }

}