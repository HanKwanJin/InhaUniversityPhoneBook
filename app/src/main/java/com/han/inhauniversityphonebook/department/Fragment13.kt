package com.han.inhauniversityphonebook.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
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
            val dialogView = CallCustomDialog(name, numberForCopy, callNumber)

            activity?.let { it -> dialogView.show(it.supportFragmentManager, "call") }
        })

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
        departmentList.add(NumberModel("긴급전화(24시간)","032-860-9119","0328609119"))
        departmentList.add(NumberModel("대학건강센터1","032-860-8311","0328608311"))
        departmentList.add(NumberModel("대학건강센터2","032-860-8312","0328608312"))

        departmentList.add(NumberModel("1생활관(1)","032-860-8317","0328608317"))
        departmentList.add(NumberModel("1생활관(2)","032-860-8319","0328608319"))
        departmentList.add(NumberModel("1생활관 당직(긴급)","032-860-8378","0328608378"))

        departmentList.add(NumberModel("2생활관(1)","032-860-7273","0328607273"))
        departmentList.add(NumberModel("2생활관(2)","032-860-7274","0328607274"))
        departmentList.add(NumberModel("2생활관 당직(긴급)","032-860-8634","0328608634"))

        departmentList.add(NumberModel("학생지원팀1","032-860-7063","0328607063"))
        departmentList.add(NumberModel("학생지원팀2","032-860-7064","0328607064"))
        departmentList.add(NumberModel("학생지원팀3","032-860-7065","0328607065"))
        departmentList.add(NumberModel("학생지원팀4","032-860-7066","0328607066"))
        departmentList.add(NumberModel("학생지원팀5","032-860-7067","0328607067"))

        departmentList.add(NumberModel("장학복지팀1","032-860-7073","0328607073"))
        departmentList.add(NumberModel("장학복지팀2","032-860-7074","0328607074"))
        departmentList.add(NumberModel("장학복지팀3","032-860-7075","0328607075"))
        departmentList.add(NumberModel("장학복지팀4","032-860-7076","0328607076"))

        departmentList.add(NumberModel("예비군연대본부1","032-860-8307","0328608307"))
        departmentList.add(NumberModel("예비군연대본부2","032-860-8308","0328608308"))
        departmentList.add(NumberModel("예비군연대본부3","032-860-8309","0328608309"))


        departmentList.add(NumberModel("학생상담실1","032-860-8262","0328608262"))
        departmentList.add(NumberModel("학생상담실2","032-860-8263","0328608263"))

        departmentList.add(NumberModel("장애인학생지원실1","032-860-7063","0328607063"))
        departmentList.add(NumberModel("장애인학생지원실2","032-860-7064","0328607064"))
        departmentList.add(NumberModel("장애인학생지원실3","032-860-7065","0328607065"))
        departmentList.add(NumberModel("장애인학생지원실4","032-860-7066","0328607066"))
        departmentList.add(NumberModel("장애인학생지원실5","032-860-7067","0328607067"))




    }
}