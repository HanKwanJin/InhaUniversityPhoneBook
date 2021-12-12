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

class Fragment13: Fragment(R.layout.fragment_number_list){
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
        fragmentNumberListBinding.textView.text = "학생지원/생활관"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("긴급전화\n(24시간)","032-860-9119","0328609119","-"))
        departmentList.add(NumberModel("대학건강센터1","032-860-8311","0328608311","학생회관 2층 215호"))
        departmentList.add(NumberModel("대학건강센터2","032-860-8312","0328608312","학생회관 2층 215호"))

        departmentList.add(NumberModel("종합상황실","032-860-8597","0328608597","본관 1층 로비"))


        departmentList.add(NumberModel("학생지원팀1","032-860-7063","0328607063","7-343호"))
        departmentList.add(NumberModel("학생지원팀2","032-860-7064","0328607064","7-343호"))
        departmentList.add(NumberModel("학생지원팀3","032-860-7065","0328607065","7-343호"))
        departmentList.add(NumberModel("학생지원팀4","032-860-7066","0328607066","7-343호"))
        departmentList.add(NumberModel("학생지원팀5","032-860-7067","0328607067","7-343호"))

        departmentList.add(NumberModel("장학복지팀1\n(학부)","032-860-7073","0328607073","7-343호"))
        departmentList.add(NumberModel("장학복지팀2\n(학부)","032-860-7074","0328607074","7-343호"))
        departmentList.add(NumberModel("장학복지팀3\n(학부)","032-860-7075","0328607075","7-343호"))
        departmentList.add(NumberModel("장학복지팀4\n(학부)","032-860-7076","0328607076","7-343호"))
        departmentList.add(NumberModel("장학복지팀\n(대학원)","032-860-8385","0328608385","7-343호"))
        departmentList.add(NumberModel("장학복지팀\n(근로)","032-860-8447","0328608447","7-343호"))

        departmentList.add(NumberModel("예비군연대본부1","032-860-8307","0328608307","7-347호"))
        departmentList.add(NumberModel("예비군연대본부2","032-860-8308","0328608308","7-347호"))
        departmentList.add(NumberModel("예비군연대본부3","032-860-8309","0328608309","7-347호"))

        departmentList.add(NumberModel("체육지원팀1","032-860-7070","0328607070","제2생활관 옆 운동부숙소 131호"))
        departmentList.add(NumberModel("체육지원팀2","032-860-7071","0328607071","제2생활관 옆 운동부숙소 131호"))
        departmentList.add(NumberModel("체육지원팀3","032-860-7072","0328607072","제2생활관 옆 운동부숙소 131호"))

        departmentList.add(NumberModel("학생상담실1","032-860-8262","0328608262","정석학술정보관 521호"))
        departmentList.add(NumberModel("학생상담실2","032-860-8263","0328608263","정석학술정보관 521호"))

        departmentList.add(NumberModel("장애인학생지원실1","032-860-7063","0328607063","7-335A호"))
        departmentList.add(NumberModel("장애인학생지원실2","032-860-7064","0328607064","7-335A호"))
        departmentList.add(NumberModel("장애인학생지원실3","032-860-7065","0328607065","7-335A호"))
        departmentList.add(NumberModel("장애인학생지원실4","032-860-7066","0328607066","7-335A호"))
        departmentList.add(NumberModel("장애인학생지원실5","032-860-7067","0328607067","7-335A호"))




    }
}