package com.yuriyyg.noteapp.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.InvalidationTracker
import com.yuriyyg.noteapp.R
import com.yuriyyg.noteapp.databinding.FragmentShowNotesBinding
import com.yuriyyg.noteapp.presentation.adapters.ListAdapter
import com.yuriyyg.noteapp.presentation.data.NotesDbModel
import com.yuriyyg.noteapp.presentation.myApplication.MyApplication
import dagger.hilt.android.AndroidEntryPoint
import java.util.Optional.empty

@AndroidEntryPoint
class ShowNotesFragment : Fragment() {



    lateinit var binding: FragmentShowNotesBinding

     val viewModel: ShowNotesViewModel by viewModels()

    private lateinit var listAdapter : ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowNotesBinding.inflate(inflater)


        binding.lifecycleOwner = viewLifecycleOwner






        listAdapter = ListAdapter (
            requireContext(),
            mutableListOf(),
            onClick = {
            val action = ShowNotesFragmentDirections.actionShowToDescription(it.description.toString())
            findNavController().navigate(action)
            },
            onDeleteClick = { note ->
                // Логика удаления заметки
                viewModel.delete(note)
            },
            onEditClick = { note ->
                // Логика редактирования заметки

                val updateFragmentAction = ShowNotesFragmentDirections
                    .actionShowToAdd(
                        update = true,
                        itemId = note.id,
                        note = note
                    )
                findNavController().navigate(updateFragmentAction)


            },)


        binding.notesList.adapter = listAdapter

        viewModel.getAll().observe(viewLifecycleOwner, Observer { noteList ->
            // Добавление нового экземпляра в адаптер и обновление
            listAdapter.addNewItem(noteList)
        })

        binding.floatingAddActionButton.setOnClickListener {
            val addFragmentAction = ShowNotesFragmentDirections.actionShowToAdd(update = false, null)
            findNavController().navigate(addFragmentAction)
        }

        return binding.root
    }



}