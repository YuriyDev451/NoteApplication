package com.yuriyyg.noteapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.yuriyyg.noteapp.R
import com.yuriyyg.noteapp.databinding.ListItemBinding
import com.yuriyyg.noteapp.presentation.data.NotesDbModel


class ListAdapter(
    val context: Context,
    private var notes: MutableList<NotesDbModel>,
    var onClick: (NotesDbModel) -> Unit,
    var onDeleteClick: (NotesDbModel) -> Unit,
    var onEditClick: (NotesDbModel) -> Unit
) : BaseAdapter(){



    fun addNewItem(newNote: List<NotesDbModel>) {
        // Mevcut ürün listesini temizle ve yeni ürünleri ekleyerek güncelle
        notes.clear()
        notes.addAll(newNote)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return notes.count()
    }

    override fun getItem(position: Int): Any {
        return notes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var newConvertView = convertView

        var holder : ViewHolder

        if (convertView == null) {
            val binding: ListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item,
                parent,
                false
            )


            newConvertView = binding.root
            holder = ViewHolder(binding,  onClick, onDeleteClick,onEditClick )
            holder.bind(notes[position])

            newConvertView?.tag = holder

            return binding.root

        } else {
            holder = convertView.tag as ViewHolder
            holder.bind(notes[position])
        }




        return newConvertView!!
    }

    private class ViewHolder(var binding: ListItemBinding,
                             var onClick: (NotesDbModel) -> Unit,
                             var onDeleteClick: (NotesDbModel) -> Unit,
                             var onEditClick: (NotesDbModel) -> Unit) {


        fun bind(note: NotesDbModel){



            binding.tvTitle.text = note.title
            binding.tvDescription.text = note.description
          //  binding.product = color


            // Обработчик нажатия на кнопку удаления
            binding.deleteButton.setOnClickListener {
                onDeleteClick(note)
            }

            // Обработчик нажатия на кнопку редактирования
            binding.editButton.setOnClickListener {
                onEditClick(note)
            }

            //Обработчик нажатия на весь элемент
            binding.root.setOnClickListener {
                onClick(note)

            }
        }
    }

}
