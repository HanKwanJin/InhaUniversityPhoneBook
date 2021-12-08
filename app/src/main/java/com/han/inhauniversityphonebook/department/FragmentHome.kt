package com.han.inhauniversityphonebook.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.han.inhauniversityphonebook.MainActivity
import com.han.inhauniversityphonebook.R
import com.han.inhauniversityphonebook.adapter.DepartmentAdapter
import com.han.inhauniversityphonebook.adapter.HomeListAdapter
import com.han.inhauniversityphonebook.databinding.FragmentHomeListBinding
import com.han.inhauniversityphonebook.databinding.FragmentNumberListBinding
import com.han.inhauniversityphonebook.model.NumberModel

class FragmentHome: Fragment(R.layout.fragment_home_list){
    private var binding: FragmentHomeListBinding? = null
    private lateinit var homeListAdapter: HomeListAdapter
    private val mainActivity = MainActivity()
    private val departmentList = mutableListOf<NumberModel>()
    private val randomText = mutableListOf<String>()
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        val fragmentHomeListBinding = FragmentHomeListBinding.bind(view)
        binding = fragmentHomeListBinding

        //홈 화면 오리 대사가 계속 바뀌도록 함
        initRandomText()
        fragmentHomeListBinding.randomTextView.text = randomText.random()

        val fragment0 = Fragment0()
        val fragment1 = Fragment1()
        val fragment2 = Fragment2()
        val fragment3 = Fragment3()
        val fragment4 = Fragment4()
        val fragment5 = Fragment5()
        val fragment6 = Fragment6()
        val fragment7 = Fragment7()
        val fragment8 = Fragment8()
        val fragment9 = Fragment9()
        val fragment10 = Fragment10()
        val fragment11 = Fragment11()
        val fragment12 = Fragment12()
        val fragment13 = Fragment13()
        val fragment14 = Fragment14()
        val fragment15 = Fragment15()
        fragmentHomeListBinding.homeDuckButton.setOnClickListener {
            Toast.makeText(context, "오리 터치", Toast.LENGTH_SHORT).show()
        }
        homeListAdapter = HomeListAdapter(onItemClicked = {
            when(it.name){
                "전체" -> replaceFragment(fragment0)
                "프런티어학부대학" ->replaceFragment(fragment1)
                "공과대학" -> replaceFragment(fragment2)
                "자연과학대학" -> replaceFragment(fragment3)
                "경영대학" -> replaceFragment(fragment4)
                "사범대학" -> replaceFragment(fragment5)
                "사회과학대학" -> replaceFragment(fragment6)
                "문과대학" -> replaceFragment(fragment7)
                "의과대학" -> replaceFragment(fragment8)
                "미래융합대학" -> replaceFragment(fragment9)
                "예술체육대학" -> replaceFragment(fragment10)
                "국제학부" -> replaceFragment(fragment11)
                "소프트웨어융합대학" -> replaceFragment(fragment12)
                "학생지원/생활관" -> replaceFragment(fragment13)
                "총학/신문" -> replaceFragment(fragment14)
                "교내IT서비스관련" -> replaceFragment(fragment15)
            }
        })

        fragmentHomeListBinding.homeRecyclerView.adapter = homeListAdapter
        fragmentHomeListBinding.homeRecyclerView.layoutManager = LinearLayoutManager(context)

        homeListAdapter.submitList(departmentList)
        homeListAdapter.notifyDataSetChanged()
    }

    private fun initRandomText() {
        randomText.clear()
        randomText.add("오리가 얼면? 언덕! 인하하하하하")
        randomText.add("(여보세요) 인하세요?")
        randomText.add("따르릉 따르릉 내가 네 인하야~~")
        randomText.add("어라 이거..어쩌면 유용할지도?")
        randomText.add("즐겨찾기하고 나를 눌러봐!")
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("전체","",""))
        departmentList.add(NumberModel("학생지원/생활관","",""))
        departmentList.add(NumberModel("총학/신문","",""))
        departmentList.add(NumberModel("교내IT서비스관련","",""))
        departmentList.add(NumberModel("프런티어학부대학","",""))
        departmentList.add(NumberModel("공과대학","",""))
        departmentList.add(NumberModel("자연과학대학","",""))
        departmentList.add(NumberModel("경영대학","",""))
        departmentList.add(NumberModel("사범대학","",""))
        departmentList.add(NumberModel("사회과학대학","",""))
        departmentList.add(NumberModel("문과대학","",""))
        departmentList.add(NumberModel("의과대학","",""))
        departmentList.add(NumberModel("미래융합대학","",""))
        departmentList.add(NumberModel("예술체육대학","",""))
        departmentList.add(NumberModel("국제학부","",""))
        departmentList.add(NumberModel("소프트웨어융합대학","",""))

    }

    private fun replaceFragment(fragment: Fragment){
        (activity as MainActivity).replaceFragment(fragment)
    }



}