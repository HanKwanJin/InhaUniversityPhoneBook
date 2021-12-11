package com.han.inhauniversityphonebook.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.han.inhauniversityphonebook.CallCustomDialog
import com.han.inhauniversityphonebook.MainActivity
import com.han.inhauniversityphonebook.R
import com.han.inhauniversityphonebook.adapter.FilterAdapter
import com.han.inhauniversityphonebook.databinding.FragmentNumberListBinding
import com.han.inhauniversityphonebook.model.NumberModel

class FragmentSearch: Fragment(R.layout.fragment_number_list){
    private var binding: FragmentNumberListBinding? = null
    private val departmentList = ArrayList<NumberModel>()
    var departmentAdapter: FilterAdapter ?= null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentNumberListBinding = FragmentNumberListBinding.bind(view)
        val fragmentHome = FragmentHome()
        binding = fragmentNumberListBinding
        departmentAdapter = FilterAdapter(departmentList, context, onItemClicked = {
            val name = it.name.toString()
            val numberForCopy = it.number.toString()
            val callNumber = it.call.toString()
            val dialogView = CallCustomDialog(name, numberForCopy, callNumber)

            activity?.let { it -> dialogView.show(it.supportFragmentManager, "call") }
        })

        fragmentNumberListBinding.backButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(fragmentHome)
        }

        fragmentNumberListBinding.departmentRecyclerView.adapter = departmentAdapter
        fragmentNumberListBinding.departmentRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentNumberListBinding.textView.text = "검색결과 입니다!"
        departmentAdapter?.submitList(departmentList)
        departmentAdapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        departmentList.clear()
        //학생지원,생활관
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

        //총학,신문
        departmentList.add(NumberModel("총학생회","032-860-8451","0328608451"))
        departmentList.add(NumberModel("인하대학신문","032-860-8321","0328608321"))
        departmentList.add(NumberModel("총대의원회","032-860-8462","0328608462"))

        //교내IT서비스관련
        departmentList.add(NumberModel("IT서비스팀1","032-860-9081","0328609081"))
        departmentList.add(NumberModel("IT서비스팀2","032-860-9082","0328609082"))
        departmentList.add(NumberModel("IT서비스팀3","032-860-9083","0328609083"))
        departmentList.add(NumberModel("IT서비스팀4","032-860-9084","0328609084"))
        departmentList.add(NumberModel("IT서비스팀5","032-860-9085","0328609085"))
        departmentList.add(NumberModel("IT서비스팀6","032-860-9086","0328609086"))
        departmentList.add(NumberModel("IT서비스팀7","032-860-9087","0328609087"))
        departmentList.add(NumberModel("IT서비스팀8","032-860-9088","0328609088"))

        //프런티어학부대학
        departmentList.add(NumberModel("학부대학 행정실 총괄","032-860-9252","0328609252"))
        departmentList.add(NumberModel("교양과정 운영(핵심,일반)","032-860-9253","0328609253"))
        departmentList.add(NumberModel("기초교양, 교원담당","032-860-9259","0328609259"))
        departmentList.add(NumberModel("교양영어, 외국인 교원","032-860-9254","0328609254"))
        departmentList.add(NumberModel("외국인 한국어 수업운영, 강의실 관리","032-860-9255","0328609255"))
        departmentList.add(NumberModel("크로스오버 수업운영","032-860-9256","0328609256"))
        departmentList.add(NumberModel("교양한국어 수업, 도우리 프로그램 운영","032-860-9257","0328609257"))
        departmentList.add(NumberModel("미래사회와 소프트웨어 수업, GEE 프로그램 운영","032-860-9307","0328609307"))

        //공과대학
        departmentList.add(NumberModel("기계공학과","032-860-7300","0328607300"))
        departmentList.add(NumberModel("항공우주공학과","032-860-7350","0328607350"))
        departmentList.add(NumberModel("조선해양공학과","032-860-7330","0328607330"))
        departmentList.add(NumberModel("산업경영공학과","032-860-7360","0328607360"))
        departmentList.add(NumberModel("화학공학과","032-860-7460","0328607460"))
        departmentList.add(NumberModel("생명공학과","032-860-7295","0328607295"))
        departmentList.add(NumberModel("고분자공학과","032-860-7480","0328607480"))
        departmentList.add(NumberModel("신소재공학과","032-860-7520","0328607520"))
        departmentList.add(NumberModel("사회인프라공학과","032-860-7560","0328607560"))
        departmentList.add(NumberModel("환경공학과","032-860-7500","0328607500"))
        departmentList.add(NumberModel("공간정보공학과","032-860-7600","0328607600"))
        departmentList.add(NumberModel("건축학부(건축공학)","032-860-7580","0328607580"))
        departmentList.add(NumberModel("건축학부(건축학)","032-860-8710","0328608710"))
        departmentList.add(NumberModel("에너지자원공학과","032-860-7550","0328607550"))
        departmentList.add(NumberModel("융합기술경영학부","032-860-8871","0328608871"))
        departmentList.add(NumberModel("전기공학과","032-860-7390","0328607390"))
        departmentList.add(NumberModel("전자공학과","032-860-7410","0328607410"))
        departmentList.add(NumberModel("정보통신공학과","032-860-7431","0328607431"))

        //자연과학대학
        departmentList.add(NumberModel("수학과","032-860-7620","0328607620"))
        departmentList.add(NumberModel("통계학과","032-860-7640","0328607640"))
        departmentList.add(NumberModel("물리학과","032-860-7650","0328607650"))
        departmentList.add(NumberModel("화학과","032-860-7670","0328607670"))
        departmentList.add(NumberModel("생명과학과","032-860-7690","0328607690"))
        departmentList.add(NumberModel("해양과학과","032-860-7700","0328607700"))
        departmentList.add(NumberModel("식품영양학과","032-860-8120","0328608120"))

        //경영대학
        departmentList.add(NumberModel("경영학과1","032-860-7730","0328607730"))
        departmentList.add(NumberModel("경영학과2","032-860-7828","0328607828"))
        departmentList.add(NumberModel("경영학과3","032-860-7750","0328607750"))
        departmentList.add(NumberModel("글로벌금육학과","032-860-7823","0328607823"))
        departmentList.add(NumberModel("아태물류학부","032-860-8222","0328608222"))
        departmentList.add(NumberModel("국제통상학과","032-860-7790","0328607790"))

        //사범대학
        departmentList.add(NumberModel("국어교육과","032-860-7840","0328607840"))
        departmentList.add(NumberModel("영어교육과","032-860-7850","0328607850"))
        departmentList.add(NumberModel("사회교육과","032-860-7860","0328607860"))
        departmentList.add(NumberModel("교육학과","032-860-7870","0328607870"))
        departmentList.add(NumberModel("체육교육과","032-860-7880","0328607880"))
        departmentList.add(NumberModel("수학교육과","032-860-8150","0328608150"))

        //사회과학대학
        departmentList.add(NumberModel("행정학과","032-860-7940","0328607940"))
        departmentList.add(NumberModel("정치외교학과","032-860-7960","0328607960"))
        departmentList.add(NumberModel("미디어커뮤니케이션학과","032-860-8790","0328608790"))
        departmentList.add(NumberModel("경제학과","032-860-7770","0328607770"))
        departmentList.add(NumberModel("소비자학과","032-860-8110","0328608110"))
        departmentList.add(NumberModel("아동심리학과","032-860-8140","0328608140"))
        departmentList.add(NumberModel("사회복지학과","032-860-8605","0328608605"))

        //문과대학
        departmentList.add(NumberModel("한국어문학과","032-860-7990","0328607990"))
        departmentList.add(NumberModel("사학과","032-860-8070","0328608070"))
        departmentList.add(NumberModel("철학과","032-860-8080","0328608080"))
        departmentList.add(NumberModel("중국학과","032-860-8050","0328608050"))
        departmentList.add(NumberModel("일본어문화학과","032-860-8060","0328608060"))
        departmentList.add(NumberModel("영어영문학과","032-860-8010","0328608010"))
        departmentList.add(NumberModel("프랑스언어문화학과","032-860-8030","0328608030"))
        departmentList.add(NumberModel("문화콘텐츠문화경영학과1","032-860-8040","0328608040"))
        departmentList.add(NumberModel("문화콘텐츠문화경영학과2","032-860-8900","0328608900"))

        //의과대학
        departmentList.add(NumberModel("의예과","032-860-8191","0328608191"))
        departmentList.add(NumberModel("간호학과","032-860-8200","0328608200"))

        //미래융합대학
        departmentList.add(NumberModel("메카트로닉스공학과","032-860-8871","0328608871"))
        departmentList.add(NumberModel("소프트웨어융합공학과","032-860-9304","0328609304"))
        departmentList.add(NumberModel("산업경영학과","032-860-9304","0328609304"))
        departmentList.add(NumberModel("금융투자학과","032-860-9304","0328609304"))

        //예술체육대학
        departmentList.add(NumberModel("조형예술학과","032-860-8160","0328608160"))
        departmentList.add(NumberModel("디자인융합학과","032-860-8170","0328608170"))
        departmentList.add(NumberModel("스포츠과학과","032-860-8180","0328608180"))
        departmentList.add(NumberModel("연극영화학과","032-860-8240","0328608240"))
        departmentList.add(NumberModel("의류디자인학과","032-860-8130","0328608130"))

        //국제학부
        departmentList.add(NumberModel("IBT학과","032-860-9125","0328609125"))
        departmentList.add(NumberModel("ISE학과","032-860-9125","0328609125"))
        departmentList.add(NumberModel("KLC학과","032-860-9125","0328609125"))

        //소프트웨어융합대학
        departmentList.add(NumberModel("인공지능공학과","032-860-9440","0328609440"))
        departmentList.add(NumberModel("데이터사이언스학과","032-860-9440","0328609440"))
        departmentList.add(NumberModel("스마트모빌리티공학과","032-860-9440","0328609440"))
        departmentList.add(NumberModel("디자인테크놀로지학과","032-860-9440","0328609440"))
        departmentList.add(NumberModel("컴퓨터공학과","032-860-7440","0328607440"))

    }

}