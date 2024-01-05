package com.yuriyyg.noteapp.presentation.data

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [NotesDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getData(context: Context): AppDatabase {
            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                val instance = Room
                    .databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "database"
                    )
                    .build()

                INSTANCE = instance
                return INSTANCE!!
            }
        }
    }

}