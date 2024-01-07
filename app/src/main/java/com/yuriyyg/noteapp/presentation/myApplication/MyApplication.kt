package com.yuriyyg.noteapp.presentation.myApplication

import android.app.Application
import com.yuriyyg.noteapp.presentation.data.AppDatabase
import com.yuriyyg.noteapp.presentation.data.NoteRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {



    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}