package com.han.inhauniversityphonebook

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.han.inhauniversityphonebook.adapter.DepartmentListAdapter
import com.han.inhauniversityphonebook.department.*
import com.han.inhauniversityphonebook.model.NumberModel

class MainActivity : AppCompatActivity() {
    private val departmentList = mutableListOf<NumberModel>()
    private lateinit var departmentListAdapter: DepartmentListAdapter
    private val leftRecyclerView: RecyclerView by lazy {
        findViewById(R.id.leftRecyclerView)
    }
    private val numberFindEditText: EditText by lazy {
        findViewById(R.id.numberFindEditText)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        initLeftList()
        departmentListAdapter = DepartmentListAdapter(onItemClicked = {
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
        leftRecyclerView.adapter = departmentListAdapter
        leftRecyclerView.layoutManager = LinearLayoutManager(this)

        departmentListAdapter.submitList(departmentList)
        departmentListAdapter.notifyDataSetChanged()

        replaceFragment(fragment0)
    }


    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.rightFrameLayout, fragment)
                commit()
            }
    }
    private fun initLeftList(){
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
}