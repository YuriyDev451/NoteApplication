package com.yuriyyg.noteapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.yuriyyg.noteapp.presentation.data.AppDatabase
import com.yuriyyg.noteapp.presentation.data.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): NotesDao {
       return appDatabase.notesDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                "database"
            )
            .build()
    }

}