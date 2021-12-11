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

class Fragment1: Fragment(R.layout.fragment_number_list){
    private var binding: FragmentNumberListBinding? = null
    private lateinit var departmentAdapter: DepartmentAdapter
    private val departmentList = mutableListOf<NumberModel>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        val fragmentNumberListBinding = FragmentNumberListBinding.bind(view)
        val fragmentHome = FragmentHome()
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
        fragmentNumberListBinding.backButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(fragmentHome)
        }
        fragmentNumberListBinding.textView.text = "프런티어학부대학"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("학부대학 행정실 총괄","032-860-9252","0328609252","60주년 1306호"))
        departmentList.add(NumberModel("교양과정 운영(핵심,일반)","032-860-9253","0328609253","60주년 1306호"))
        departmentList.add(NumberModel("기초교양, 교원담당","032-860-9259","0328609259","60주년 1306호"))
        departmentList.add(NumberModel("교양영어, 외국인 교원","032-860-9254","0328609254","60주년 1306호"))
        departmentList.add(NumberModel("외국인 한국어 수업운영, 강의실 관리","032-860-9255","0328609255","60주년 1306호"))
        departmentList.add(NumberModel("크로스오버 수업운영","032-860-9256","0328609256","60주년 1306호"))
        departmentList.add(NumberModel("교양한국어 수업, 도우리 프로그램 운영","032-860-9257","0328609257","60주년 1306호"))
        departmentList.add(NumberModel("미래사회와 소프트웨어 수업, GEE 프로그램 운영","032-860-9307","0328609307","60주년 1306호"))


    }
}