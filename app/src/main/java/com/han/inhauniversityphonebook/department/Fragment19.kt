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

class Fragment19: Fragment(R.layout.fragment_number_list){
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

        fragmentNumberListBinding.textView.text = "교무처"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("학사관리팀1","032-860-7041","0328607041","7-303A"))
        departmentList.add(NumberModel("학사관리팀2","032-860-7042","0328607042","7-303A"))
        departmentList.add(NumberModel("학사관리팀3","032-860-7043","0328607043","7-303A"))
        departmentList.add(NumberModel("학사관리팀4","032-860-7044","0328607044","7-303A"))
        departmentList.add(NumberModel("학사관리팀5","032-860-7045","0328607045","7-303A"))
        departmentList.add(NumberModel("학사관리팀6","032-860-7046","0328607046","7-303A"))
        departmentList.add(NumberModel("학사관리팀7","032-860-7047","0328607047","7-303A"))
        departmentList.add(NumberModel("학사관리팀8","032-860-7048","0328607048","7-303A"))

        departmentList.add(NumberModel("교육기획팀1","032-860-8100","0328608100","1-123호"))
        departmentList.add(NumberModel("교육기획팀2","032-860-8101","0328608101","1-123호"))
        departmentList.add(NumberModel("교육기획팀3","032-860-8102","0328608102","1-123호"))
        departmentList.add(NumberModel("교육기획팀4","032-860-8103","0328608103","1-123호"))
        departmentList.add(NumberModel("교육기획팀5","032-860-8104","0328608104","1-123호"))
        departmentList.add(NumberModel("교육기획팀6","032-860-8105","0328608105","1-123호"))
        departmentList.add(NumberModel("교육기획팀7","032-860-8106","0328608106","1-123호"))
        departmentList.add(NumberModel("교육기획팀8","032-860-8107","0328608107","1-123호"))

        departmentList.add(NumberModel("교육효과성센터1","032-860-9315","0328609315","1-422A호"))
        departmentList.add(NumberModel("교육효과성센터2","032-860-9316","0328609316","1-422A호"))
        departmentList.add(NumberModel("교육효과성센터3","032-860-9317","0328609317","1-422A호"))

        departmentList.add(NumberModel("교원인사팀1","032-860-7051","0328607051","1-142호"))
        departmentList.add(NumberModel("교원인사팀2","032-860-7052","0328607052","1-142호"))
        departmentList.add(NumberModel("교원인사팀3","032-860-7053","0328607053","1-142호"))
        departmentList.add(NumberModel("교원인사팀4","032-860-7054","0328607054","1-142호"))
        departmentList.add(NumberModel("교원인사팀5","032-860-7055","0328607055","1-142호"))
        departmentList.add(NumberModel("교원인사팀6","032-860-7056","0328607056","1-142호"))
        departmentList.add(NumberModel("교원인사팀7","032-860-7057","0328607057","1-142호"))

        departmentList.add(NumberModel("교수학습개발센터1","032-860-7023","0328607023","60주년-1307호"))
        departmentList.add(NumberModel("교수학습개발센터2","032-860-7024","0328607024","60주년-1307호"))

        departmentList.add(NumberModel("원격교육지원센터1","032-860-7025","0328607025","60주년-1307호"))
        departmentList.add(NumberModel("원격교육지원센터2","032-860-8919","0328608919","60주년-1307호"))










    }
}