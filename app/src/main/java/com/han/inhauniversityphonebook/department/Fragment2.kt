package com.han.inhauniversityphonebook.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.han.inhauniversityphonebook.CallCustomDialog
import com.han.inhauniversityphonebook.MainActivity
import com.han.inhauniversityphonebook.R
import com.han.inhauniversityphonebook.adapter.DepartmentAdapter
import com.han.inhauniversityphonebook.databinding.FragmentNumberListBinding
import com.han.inhauniversityphonebook.model.NumberModel

class Fragment2: Fragment(R.layout.fragment_number_list){
    private var binding: FragmentNumberListBinding? = null
    private lateinit var departmentAdapter:DepartmentAdapter
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
            val dialogView = CallCustomDialog(name, numberForCopy, callNumber,location)

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
        fragmentNumberListBinding.textView.text = "공과대학"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("기계공학과","032-860-7300","0328607300","2북 291호"))
        departmentList.add(NumberModel("항공우주공학과","032-860-7350","0328607350","2남 235호"))
        departmentList.add(NumberModel("조선해양공학과","032-860-7330","0328607330","2북 491A호"))
        departmentList.add(NumberModel("산업경영공학과","032-860-7360","0328607360","2북 477A호"))
        departmentList.add(NumberModel("화학공학과","032-860-7460","0328607460","60주년 801호"))
        departmentList.add(NumberModel("생명공학과","032-860-7295","0328607295","2남 231A호"))
        departmentList.add(NumberModel("고분자공학과","032-860-7480","0328607480","2북 571호"))
        departmentList.add(NumberModel("신소재공학과","032-860-7520","0328607520","5북 135호"))
        departmentList.add(NumberModel("사회인프라공학과","032-860-7560","0328607560","2남 207호"))
        departmentList.add(NumberModel("환경공학과","032-860-7500","0328607500","2동 441호"))
        departmentList.add(NumberModel("공간정보공학과","032-860-7600","0328607600","4호관 302호"))
        departmentList.add(NumberModel("건축학부(건축공학)","032-860-7580","0328607580","2남 413호"))
        departmentList.add(NumberModel("건축학부(건축학)","032-860-8710","0328608710","2남 413호"))
        departmentList.add(NumberModel("에너지자원공학과","032-860-7550","0328607550","2남 215호"))
        departmentList.add(NumberModel("융합기술경영학부","032-860-8871","0328608871","미래융합대학관 106호"))
        departmentList.add(NumberModel("전기공학과","032-860-7390","0328607390","하이테크센터 603호"))
        departmentList.add(NumberModel("전자공학과","032-860-7410","0328607410","하이테크센터 801호"))
        departmentList.add(NumberModel("정보통신공학과","032-860-7431","0328607431","하이테크센터 416호"))
    }
}