package com.han.inhauniversityphonebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.han.inhauniversityphonebook.databinding.ItemDepartmentBinding
import com.han.inhauniversityphonebook.databinding.ItemHomeBinding
import com.han.inhauniversityphonebook.model.NumberModel
import kotlin.coroutines.coroutineContext

class DepartmentAdapter(val onItemClicked: (NumberModel) -> Unit, val duckClicked: () -> Unit): ListAdapter<NumberModel, DepartmentAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: ItemDepartmentBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(numberModel: NumberModel){
            binding.root.setOnClickListener {
                onItemClicked(numberModel)
            }
            binding.favoriteButton.setOnClickListener {
                duckClicked()
            }
            binding.departmentNameTextView.text = numberModel.name
            binding.departmentNumberTextView.text = numberModel.number
            binding.departmentLocationTextView.text = numberModel.location



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDepartmentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<NumberModel>(){
            override fun areItemsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}