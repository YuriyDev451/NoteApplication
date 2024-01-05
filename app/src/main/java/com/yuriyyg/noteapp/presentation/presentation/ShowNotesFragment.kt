package com.yuriyyg.noteapp.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.InvalidationTracker
import com.yuriyyg.noteapp.R
import com.yuriyyg.noteapp.databinding.FragmentShowNotesBinding
import com.yuriyyg.noteapp.presentation.adapters.ListAdapter
import com.yuriyyg.noteapp.presentation.myApplication.MyApplication


class ShowNotesFragment : Fragment() {



    lateinit var binding: FragmentShowNotesBinding

    lateinit var viewModel: ShowNotesViewModel

    private lateinit var listAdapter : ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowNotesBinding.inflate(inflater)
        viewModel= ViewModelProvider(this)[ShowNotesViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner
        //binding.viewModel = viewModel

        viewModel.repository = (activity?.application as MyApplication).repository

        listAdapter = ListAdapter (requireContext(), mutableListOf(), onClick = {
            //val action = ShowNotesFragmentDirections.actionShowToDescription()
            //findNavController().navigate(action)
        })
        binding.notesList.adapter = listAdapter

        viewModel.getAll().observe(viewLifecycleOwner, Observer { noteList ->
            // Adaptöre yeni ürünler eklemek ve listeyi güncellemek
            listAdapter.addNewItem(noteList)
        })

        binding.floatingAddActionButton.setOnClickListener {
            openAddFragment()
        }


        return binding.root
    }


    fun openAddFragment(){
        val action = ShowNotesFragmentDirections.actionShowToAdd()
        findNavController().navigate(action)
    }


}