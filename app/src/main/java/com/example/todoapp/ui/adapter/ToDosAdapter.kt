package com.example.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.ToDos
import com.example.todoapp.databinding.CardDesignBinding
import com.example.todoapp.databinding.FragmentSaveBinding
import com.example.todoapp.ui.fragment.MainFragmentDirections
import com.google.android.material.snackbar.Snackbar

class ToDosAdapter(var mContext:Context,var toDosList:List<ToDos>)
    : RecyclerView.Adapter<ToDosAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding:CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {//position : 0,1,2
        val toDo = toDosList.get(position)
        val desing = holder.binding
        desing.textViewName.text = toDo.name

        desing.cardViewRow.setOnClickListener {
            val toUpdateScreen = MainFragmentDirections.toUpdateScreen(toDo = toDo)
            Navigation.findNavController(it).navigate(toUpdateScreen)
        }

        desing.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${toDo.name} ?",Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    delete(toDo.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {//size : 3
        return toDosList.size
    }

    fun delete(id:Int){
        Log.e("ToDoAppOut Delete",id.toString())
    }
}