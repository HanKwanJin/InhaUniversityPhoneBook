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

class Fragment16: Fragment(R.layout.fragment_number_list){
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

        fragmentNumberListBinding.textView.text = "교외"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("야생동물구조관리센터1(인천)", "032-858-9702","0328589702","연수구 송도국제대로 372번길21"))
        departmentList.add(NumberModel("야생동물구조관리센터2(인천)", "032-858-9703","0328589703","연수구 송도국제대로 372번길21"))
        departmentList.add(NumberModel("야생동물구조관리센터3(인천)", "032-858-9704","0328589704","연수구 송도국제대로 372번길21"))
        departmentList.add(NumberModel("미추홀구청", "032-887-1011","0328871011","미추홀구 동적이로95"))
        departmentList.add(NumberModel("인하대부속병원", "032-890-2114","0328902114","중구 인항로27"))
        departmentList.add(NumberModel("미추홀구 보건소1", "032-880-5455","0328805455","미추홀구 주안서로25"))
        departmentList.add(NumberModel("미추홀구 보건소2", "032-880-5456","0328805456","미추홀구 주안서로25"))
        departmentList.add(NumberModel("미추홀구 보건소3", "032-880-5457","0328805457","미추홀구 주안서로25"))
        departmentList.add(NumberModel("미추홀소방서", "032-870-3214","0328703214","미추홀구 인하로190"))
        departmentList.add(NumberModel("미추홀경찰서", "182","182","미추홀구 매소홀로290번길32"))
        departmentList.add(NumberModel("한국장학재단", "1599-2000","15992000","대구광역시 동구 신암로125"))
        departmentList.add(NumberModel("KEB하나은행\n(인하대)", "032-863-1111","0328631111","학생회관 2층"))
        departmentList.add(NumberModel("대학서적\n(인하대)", "032-868-9667","0328689667","학생회관 1층"))
        departmentList.add(NumberModel("하텍 인쇄실 2층", "010-8508-3975","01085083975","하이테크관 2층"))






    }
}