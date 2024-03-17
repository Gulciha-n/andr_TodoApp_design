package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDos
import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.ui.adapter.ToDosAdapter

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        val toDoList = ArrayList<ToDos>()
        val toDo1 = ToDos(1,"Sport")
        val toDo2 = ToDos(2,"Reading")
        val toDo3 = ToDos(3,"Walking")
        toDoList.add(toDo1)
        toDoList.add(toDo2)
        toDoList.add(toDo3)

        val toDosAdapter = ToDosAdapter(requireContext(),toDoList)
        binding.toDosRecyclerView.adapter = toDosAdapter

        binding.toDosRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toSaveScreen)
        }

        /*binding.buttonToUpdate.setOnClickListener {
            val toDo = ToDos(1,"Sport")
            val toUpdateScreen = MainFragmentDirections.toUpdateScreen(toDo = toDo)
            Navigation.findNavController(it).navigate(toUpdateScreen)
        }*/

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe çalışır.
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Klavye ara buttonu ile çalışır.
                search(query)
                return true
            }
        })

        return binding.root
    }

    fun search(searchText:String){
        Log.e("ToDoAppOut Search",searchText)
    }
}

