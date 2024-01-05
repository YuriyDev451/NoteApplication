package com.yuriyyg.noteapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.yuriyyg.noteapp.R
import com.yuriyyg.noteapp.databinding.ListItemBinding
import com.yuriyyg.noteapp.presentation.data.NotesDbModel

//import com.example.navigationapp.R
//import com.example.navigationapp.databinding.ListItemBinding


class ListAdapter(val context: Context, private var notes: MutableList<NotesDbModel>, var onClick: (NotesDbModel) -> Unit) : BaseAdapter(){


//        fun addNewItem(newData: Colors) {
//            productList.clear()
//            productList.add(newData)
//            notifyDataSetChanged()
//        }

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
            holder = ViewHolder(binding, onClick)
            holder.bind(notes[position])

            newConvertView?.tag = holder

            return binding.root

        } else {
            holder = convertView.tag as ViewHolder
            holder.bind(notes[position])
        }

        return newConvertView!!
    }

    private class ViewHolder(var binding: ListItemBinding, var onClick: (NotesDbModel) -> Unit) {
        fun bind(note: NotesDbModel){

//            binding.textView.text = color.name
//            binding.textView2.text = color.count

            binding.tvTitle.text = note.title
            binding.tvDescription.text = note.description
          //  binding.product = color

            binding.deleteButton.setOnClickListener {

            }

            binding.root.setOnClickListener {
               // onClick(binding.product as NotesDbModel)


            }
        }
    }

}
