package com.yuriyyg.noteapp.presentation.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class NotesDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo (name = "title")
    val title:String?,
    @ColumnInfo(name = "description")
    val description: String?
):Parcelable{
    companion object {
        @JvmStatic
        fun getDefault(): NotesDbModel {
            return NotesDbModel(0, "", "")
        }
    }
}
