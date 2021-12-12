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

class Fragment20: Fragment(R.layout.fragment_number_list){
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

        fragmentNumberListBinding.textView.text = "사무처"
        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)

        departmentAdapter.submitList(departmentList)
        departmentAdapter.notifyDataSetChanged()
    }

    private fun initList(){
        departmentList.clear()
        departmentList.add(NumberModel("총무팀1","032-860-7093","0328607093","1-101호"))
        departmentList.add(NumberModel("총무팀2","032-860-7094","0328607094","1-101호"))
        departmentList.add(NumberModel("총무팀3","032-860-7095","0328607095","1-101호"))
        departmentList.add(NumberModel("총무팀4","032-860-7096","0328607096","1-101호"))
        departmentList.add(NumberModel("총무팀5","032-860-7097","0328607097","1-101호"))
        departmentList.add(NumberModel("총무팀6","032-860-7098","0328607098","1-101호"))
        departmentList.add(NumberModel("총무팀7","032-860-7099","0328607099","1-101호"))

        departmentList.add(NumberModel("구매자산팀1","032-860-7116","0328607116","1-101호"))
        departmentList.add(NumberModel("구매자산팀2","032-860-7117","0328607117","1-101호"))
        departmentList.add(NumberModel("구매자산팀3","032-860-8881","0328608881","1-101호"))
        departmentList.add(NumberModel("구매자산팀4","032-860-8882","0328608882","1-101호"))

        departmentList.add(NumberModel("시설안전팀1","032-860-7106","0328607106","1-101B호"))
        departmentList.add(NumberModel("시설안전팀2","032-860-7107","0328607107","1-101B호"))
        departmentList.add(NumberModel("시설안전팀3","032-860-7108","0328607108","1-101B호"))
        departmentList.add(NumberModel("시설안전팀4","032-860-7109","0328607109","1-101B호"))
        departmentList.add(NumberModel("시설안전팀5","032-860-7110","0328607110","1-101B호"))
        departmentList.add(NumberModel("시설안전팀6","032-860-7111","0328607111","1-101B호"))
        departmentList.add(NumberModel("시설안전팀7","032-860-7112","0328607112","1-101B호"))

        departmentList.add(NumberModel("재무팀1","032-860-7124","0328607124","1-140호"))
        departmentList.add(NumberModel("재무팀2","032-860-7125","0328607125","1-140호"))
        departmentList.add(NumberModel("재무팀3","032-860-7126","0328607126","1-140호"))
        departmentList.add(NumberModel("재무팀4","032-860-7127","0328607127","1-140호"))
        departmentList.add(NumberModel("재무팀5","032-860-7128","0328607128","1-140호"))
        departmentList.add(NumberModel("재무팀6","032-860-7129","0328607129","1-140호"))
        departmentList.add(NumberModel("재무팀7","032-860-7130","0328607130","1-140호"))
        departmentList.add(NumberModel("재무팀8","032-860-7131","0328607131","1-140호"))
        departmentList.add(NumberModel("재무팀9","032-860-7132","0328607132","1-140호"))
        departmentList.add(NumberModel("재무팀10","032-860-7133","0328607133","1-140호"))
        departmentList.add(NumberModel("재무팀11","032-860-7134","0328607134","1-140호"))
        departmentList.add(NumberModel("재무팀12","032-860-7135","0328607135","1-140호"))
        departmentList.add(NumberModel("재무팀13","032-860-7136","0328607136","1-140호"))
        departmentList.add(NumberModel("재무팀14","032-860-7137","0328607137","1-140호"))
        departmentList.add(NumberModel("재무팀15","032-860-7138","0328607138","1-140호"))
        departmentList.add(NumberModel("재무팀16","032-860-7139","0328607139","1-140호"))





    }
}