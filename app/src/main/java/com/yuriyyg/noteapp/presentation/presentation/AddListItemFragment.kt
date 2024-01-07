package com.yuriyyg.noteapp.presentation.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yuriyyg.noteapp.R
import com.yuriyyg.noteapp.databinding.FragmentAddListItemBinding
import com.yuriyyg.noteapp.presentation.data.NotesDbModel
import com.yuriyyg.noteapp.presentation.myApplication.MyApplication
import dagger.hilt.android.AndroidEntryPoint
import java.util.zip.Inflater

@AndroidEntryPoint
class AddListItemFragment : Fragment() {



    lateinit var binding: FragmentAddListItemBinding

     val viewModel: AddListItemViewModel by viewModels()

    private val args: AddListItemFragmentArgs by navArgs()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddListItemBinding.inflate(inflater)


        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel



        val isUpdate = args.update
        val id = args.itemId
        val title = args.note?.title
        val description = args.note?.description

        if (!title.isNullOrEmpty()){
            viewModel.title.value  = title.toString()
            viewModel.description.value = description.toString()
        }else{
            viewModel.title.value  = ""
            viewModel.description.value = ""
        }


        binding.addButton.setOnClickListener {

            if (viewModel.parseEditText()) {

                if (isUpdate) {
                    val itemId = id
                    val note = NotesDbModel(
                        itemId,
                        viewModel.title.value.orEmpty(),
                        viewModel.description.value.orEmpty()
                    )
                    // Это обновление, выполните необходимую логику для обновления элемента

                    viewModel.update(note)
                    // Загрузите данные элемента из базы данных и отобразите их в вашем интерфейсе
                } else {
                    val note = NotesDbModel(
                        0,
                        viewModel.title.value.orEmpty(),
                        viewModel.description.value.orEmpty()
                    )
                    // Это добавление, выполните логику для добавления нового элемента
                    viewModel.insert(note)
                }


                val action =
                    AddListItemFragmentDirections.actionAddListItemFragmentToShowNotesFragment()
                findNavController().navigate(action)
            }else{
                Toast.makeText(context, "Заполните поля", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }


}