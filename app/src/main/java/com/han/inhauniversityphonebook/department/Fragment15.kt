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

class Fragment15: Fragment(R.layout.fragment_number_list){
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

        fragmentNumberListBinding.textView.text = "교내IT서비스관련"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("IT서비스팀1","032-860-9081","0328609081","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀2","032-860-9082","0328609082","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀3","032-860-9083","0328609083","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀4","032-860-9084","0328609084","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀5","032-860-9085","0328609085","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀6","032-860-9086","0328609086","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀7","032-860-9087","0328609087","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀8","032-860-9088","0328609088","60주년 기념관 1408호"))





    }
}