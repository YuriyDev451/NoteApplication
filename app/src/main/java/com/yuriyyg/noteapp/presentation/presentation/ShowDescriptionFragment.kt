package com.yuriyyg.noteapp.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuriyyg.noteapp.R


class ShowDescriptionFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_show_description, container, false)
    }

    companion object {
        fun newInstance() = ShowDescriptionFragment()
    }
}