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

class Fragment21: Fragment(R.layout.fragment_number_list){
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

        fragmentNumberListBinding.textView.text = "기획처"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("전략기획팀1","032-860-7142","0328607142","1-332호"))
        departmentList.add(NumberModel("전략기획팀2","032-860-7143","0328607143","1-332호"))
        departmentList.add(NumberModel("전략기획팀3","032-860-7144","0328607144","1-332호"))
        departmentList.add(NumberModel("전략기획팀4","032-860-7145","0328607145","1-332호"))
        departmentList.add(NumberModel("전략기획팀5","032-860-7146","0328607146","1-332호"))
        departmentList.add(NumberModel("전략기획팀6","032-860-7147","0328607147","1-332호"))
        departmentList.add(NumberModel("전략기획팀7","032-860-7148","0328607148","1-332호"))
        departmentList.add(NumberModel("전략기획팀8","032-860-7149","0328607149","1-332호"))

        departmentList.add(NumberModel("감사팀1","032-860-9310","0328609310","1-330호"))
        departmentList.add(NumberModel("감사팀2","032-860-9312","0328609312","1-330호"))
        departmentList.add(NumberModel("감사팀3","032-860-9313","0328609313","1-330호"))

        departmentList.add(NumberModel("캠퍼스공간팀1","032-860-7158","0328607158","1-427호"))
        departmentList.add(NumberModel("캠퍼스공간팀2","032-860-7159","0328607159","1-427호"))







    }
}