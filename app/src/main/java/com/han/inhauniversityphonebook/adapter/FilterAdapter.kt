package com.han.inhauniversityphonebook.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.han.inhauniversityphonebook.databinding.ItemDepartmentBinding
import com.han.inhauniversityphonebook.model.NumberModel
import java.util.*
import kotlin.collections.ArrayList

class FilterAdapter(myData: ArrayList<NumberModel>, val context: Context?, val onItemClicked: (NumberModel) -> Unit,val duckClicked: () -> Unit): ListAdapter<NumberModel, FilterAdapter.ViewHolder>(diffUtil) {
    private var items: ArrayList<NumberModel> ?= null
    private val arrayList = ArrayList<NumberModel>()
    init {
        this.items = myData
        arrayList.addAll(items!!)
    }
    inner class ViewHolder(private val binding: ItemDepartmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(numberModel: NumberModel) {
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


    @SuppressLint("NotifyDataSetChanged")
    fun filter(charText: String){
        charText.lowercase(Locale.getDefault())

        items?.clear()
        if(charText.isEmpty()){
            items?.addAll(arrayList)
        }else{
            for(data in arrayList){
                val name = data.name.toString()
                val number = data.call.toString()
                if(name.lowercase().contains(charText) || number.contains(charText)){
                    items?.add(data)
                }
            }
        }

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items!!.size
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