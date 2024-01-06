package com.yuriyyg.noteapp.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.yuriyyg.noteapp.R
import com.yuriyyg.noteapp.databinding.FragmentAddListItemBinding
import com.yuriyyg.noteapp.databinding.FragmentShowDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowDescriptionFragment : Fragment() {

    private val args: ShowDescriptionFragmentArgs by navArgs()
    lateinit var binding: FragmentShowDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowDescriptionBinding.inflate(inflater)

        val desc = args.description

        binding.tvDescription.text = desc
        return binding.root
    }


}