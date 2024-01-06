package com.yuriyyg.noteapp.presentation.di

import com.yuriyyg.noteapp.presentation.data.NoteRepository
import com.yuriyyg.noteapp.presentation.data.NoteRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NoteRepositoryModule {
    @Binds
    abstract  fun bindRepository(prm: NoteRepository): NoteRepositoryInterface
}