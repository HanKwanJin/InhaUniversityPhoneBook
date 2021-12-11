package com.han.inhauniversityphonebook.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.han.inhauniversityphonebook.CallCustomDialog
import com.han.inhauniversityphonebook.MainActivity
import com.han.inhauniversityphonebook.R
import com.han.inhauniversityphonebook.adapter.DepartmentAdapter
import com.han.inhauniversityphonebook.databinding.FragmentNumberListBinding
import com.han.inhauniversityphonebook.model.NumberModel

class Fragment7: Fragment(R.layout.fragment_number_list){
    private var binding: FragmentNumberListBinding? = null
    private lateinit var departmentAdapter: DepartmentAdapter
    private val departmentList = mutableListOf<NumberModel>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        val fragmentNumberListBinding = FragmentNumberListBinding.bind(view)
        binding = fragmentNumberListBinding

        departmentAdapter = DepartmentAdapter(onItemClicked = {
            val name = it.name.toString()
            val numberForCopy = it.number.toString()
            val callNumber = it.call.toString()
            val location = it.location.toString()
            val dialogView = CallCustomDialog(name, numberForCopy, callNumber, location)

            activity?.let { it -> dialogView.show(it.supportFragmentManager, "call") }
        }, duckClicked = {
            Toast.makeText(context, "쉿! 개발중\uD83E\uDD2B", Toast.LENGTH_SHORT).show()
        })
        val fragmentFavorite = FragmentFavorite()
        fragmentNumberListBinding.favoriteDuckButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(fragmentFavorite)
        }
        val fragmentHome = FragmentHome()
        fragmentNumberListBinding.backButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(fragmentHome)
        }
        fragmentNumberListBinding.textView.text = "문과대학"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("한국어문학과","032-860-7990","0328607990","5남 210호"))
        departmentList.add(NumberModel("사학과","032-860-8070","0328608070","5남 215호"))
        departmentList.add(NumberModel("철학과","032-860-8080","0328608080","5남 262호"))
        departmentList.add(NumberModel("중국학과","032-860-8050","0328608050","5남 269호"))
        departmentList.add(NumberModel("일본어문화학과","032-860-8060","0328608060","5남 102호"))
        departmentList.add(NumberModel("영어영문학과","032-860-8010","0328608010","5남 115호"))
        departmentList.add(NumberModel("프랑스언어문화학과","032-860-8030","0328608030","5남 414호"))
        departmentList.add(NumberModel("문화콘텐츠문화경영학과1","032-860-8040","0328608040","5남 265호"))
        departmentList.add(NumberModel("문화콘텐츠문화경영학과2","032-860-8900","0328608900","5남 265호"))
    }
}