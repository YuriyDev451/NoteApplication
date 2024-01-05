package com.yuriyyg.noteapp.presentation.myApplication

import android.app.Application
import com.yuriyyg.noteapp.presentation.data.AppDatabase
import com.yuriyyg.noteapp.presentation.data.NoteRepository

class MyApplication: Application() {


    val database by lazy { AppDatabase.getData(this) }
    val repository by lazy {NoteRepository(database.notesDao())}

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}