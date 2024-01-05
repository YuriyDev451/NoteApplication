package com.yuriyyg.noteapp.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yuriyyg.noteapp.R
import com.yuriyyg.noteapp.databinding.FragmentAddListItemBinding
import com.yuriyyg.noteapp.presentation.data.NotesDbModel
import com.yuriyyg.noteapp.presentation.myApplication.MyApplication
import java.util.zip.Inflater


class AddListItemFragment : Fragment() {



    lateinit var binding: FragmentAddListItemBinding
    lateinit var viewModel: AddListItemViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddListItemBinding.inflate(inflater)
        viewModel= ViewModelProvider(this)[AddListItemViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.repository = (activity?.application as MyApplication).repository

        binding.addButton.setOnClickListener {
            val note = NotesDbModel(
                0,
                viewModel.title.value.orEmpty(),
                viewModel.description.value.orEmpty())

            viewModel.insert(note)
            val action = AddListItemFragmentDirections.actionAddListItemFragmentToShowNotesFragment()
            findNavController().navigate(action)

        }

        return binding.root
    }


}