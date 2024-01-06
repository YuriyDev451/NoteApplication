package com.yuriyyg.noteapp.presentation.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuriyyg.noteapp.presentation.data.NoteRepository
import com.yuriyyg.noteapp.presentation.data.NotesDbModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddListItemViewModel @Inject constructor(var repository: NoteRepository): ViewModel() {


    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    fun insert(note: NotesDbModel){
        viewModelScope.launch {
            repository.insert(note)
        }

    }

    fun update (note: NotesDbModel){
        viewModelScope.launch {
            repository.update(note)
        }
    }



    fun parseEditText(): Boolean{
        val name = title.value.orEmpty()
        val description = description.value.orEmpty()
        return name.isNotEmpty() && description.isNotEmpty()
    }



}