package com.han.inhauniversityphonebook.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        //교무처
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


        //학생지원
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

        //사무처
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

        //기획처
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

        //정보통신처
        departmentList.add(NumberModel("IT개발팀1","032-860-9060","0328609060","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀2","032-860-9061","0328609061","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀3","032-860-9062","0328609062","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀4","032-860-9063","0328609063","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀5","032-860-9064","0328609064","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀6","032-860-9065","0328609065","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀7","032-860-9066","0328609066","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀8","032-860-9067","0328609067","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT개발팀9","032-860-9087","0328609087","60주년 기념관 1408호"))

        departmentList.add(NumberModel("IT서비스팀1","032-860-9081","0328609081","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀2","032-860-9082","0328609082","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀3","032-860-9083","0328609083","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀4","032-860-9084","0328609084","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀5","032-860-9085","0328609085","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀6","032-860-9086","0328609086","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀7","032-860-9087","0328609087","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT서비스팀8","032-860-9088","0328609088","60주년 기념관 1408호"))

        departmentList.add(NumberModel("IT인프라팀1","032-860-9052","0328609052","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT인프라팀2","032-860-9053","0328609053","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT인프라팀3","032-860-9054","0328609054","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT인프라팀4","032-860-9055","0328609055","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT인프라팀5","032-860-9056","0328609056","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT인프라팀6","032-860-9091","0328609091","60주년 기념관 1408호"))
        departmentList.add(NumberModel("IT인프라팀7","032-860-9092","0328609092","60주년 기념관 1408호"))

        //입학처
        departmentList.add(NumberModel("입학팀1","032-860-7221","0328607221","1-130호"))
        departmentList.add(NumberModel("입학팀2","032-860-7222","0328607222","1-130호"))
        departmentList.add(NumberModel("입학팀3","032-860-7223","0328607223","1-130호"))
        departmentList.add(NumberModel("입학팀4","032-860-7224","0328607224","1-130호"))
        departmentList.add(NumberModel("입학팀5","032-860-7225","0328607225","1-130호"))
        departmentList.add(NumberModel("입학팀6","032-860-9231","0328609231","1-130호"))
        departmentList.add(NumberModel("입학팀7","032-860-9232","0328609232","1-130호"))

        //대외협력처
        departmentList.add(NumberModel("대외홍보팀1","032-860-7193","0328607193","인하드림센터 504호"))
        departmentList.add(NumberModel("대외홍보팀2","032-860-7194","0328607194","인하드림센터 504호"))
        departmentList.add(NumberModel("대외홍보팀3","032-860-7195","0328607195","인하드림센터 504호"))

        departmentList.add(NumberModel("발전협력팀1","032-860-7104","0328607104","1-123호"))
        departmentList.add(NumberModel("발전협력팀2","032-860-7159","0328607159","1-123호"))
        departmentList.add(NumberModel("발전협력팀3","032-860-7196","0328607196","1-123호"))
        departmentList.add(NumberModel("발전협력팀4","032-860-7197","0328607197","1-123호"))

        //국제처
        departmentList.add(NumberModel("국제교류팀1","032-860-7031","0328607031","7-313호"))
        departmentList.add(NumberModel("국제교류팀2","032-860-7032","0328607032","7-313호"))
        departmentList.add(NumberModel("국제교류팀3","032-860-7033","0328607033","7-313호"))
        departmentList.add(NumberModel("국제교류팀4","032-860-7034","0328607034","7-313호"))

        departmentList.add(NumberModel("국제지원팀1","032-860-7035","0328607035","7-505호"))
        departmentList.add(NumberModel("국제지원팀2","032-860-7036","0328607036","7-505호"))
        departmentList.add(NumberModel("국제지원팀3","032-860-7037","0328607037","7-505호"))
        departmentList.add(NumberModel("국제지원팀4","032-860-7038","0328607038","7-505호"))
        departmentList.add(NumberModel("국제지원팀5","032-860-7039","0328607039","7-505호"))

        //생활관
        departmentList.add(NumberModel("1생활관(1)","032-860-8317","0328608317","제1생활관 141호"))
        departmentList.add(NumberModel("1생활관(2)","032-860-8319","0328608319","제1생활관 141호"))
        departmentList.add(NumberModel("1생활관 당직(긴급)","032-860-8378","0328608378","1관 당직실(야간)"))
        departmentList.add(NumberModel("2생활관(1)","032-860-7273","0328607273","제2생활관 103호"))
        departmentList.add(NumberModel("2생활관(2)","032-860-7274","0328607274","제2생활관 103호"))
        departmentList.add(NumberModel("3생활관","032-860-7275","0328607275","제2생활관 103호"))
        departmentList.add(NumberModel("2,3생활관 당직(긴급)","032-860-8634","0328608634","2,3관 당직실(야간)"))


        //학생자치기구
        departmentList.add(NumberModel("총학생회","032-860-8451","0328608451","학생회관 407호"))
        departmentList.add(NumberModel("총대의원회","032-860-8462","0328608462","학생회관 453호"))
        departmentList.add(NumberModel("동아리연합회","010-5685-0207","01056850207","동아리연합회"))
        departmentList.add(NumberModel("졸업준비학생회","032-860-8460","0328608460","학생회관 4층"))
        departmentList.add(NumberModel("생활도서관","032-860-8472","0328608472","학생회관 410호"))

        //신문사&방송국
        departmentList.add(NumberModel("인하대학신문사","032-860-8321","0328608321","7-417호"))
        departmentList.add(NumberModel("인하대방속국1","032-860-8325","0328608325","학생회관 3층"))
        departmentList.add(NumberModel("인하대방속국2","032-860-8326","0328608326","학생회관 3층"))




        //프런티어학부대학
        departmentList.add(NumberModel("학부대학 행정실 총괄","032-860-9252","0328609252","60주년 1306호"))
        departmentList.add(NumberModel("교양과정 운영(핵심,일반)","032-860-9253","0328609253","60주년 1306호"))
        departmentList.add(NumberModel("기초교양, 교원담당","032-860-9259","0328609259","60주년 1306호"))
        departmentList.add(NumberModel("교양영어, 외국인 교원","032-860-9254","0328609254","60주년 1306호"))
        departmentList.add(NumberModel("외국인 한국어 수업운영, 강의실 관리","032-860-9255","0328609255","60주년 1306호"))
        departmentList.add(NumberModel("크로스오버 수업운영","032-860-9256","0328609256","60주년 1306호"))
        departmentList.add(NumberModel("교양한국어 수업, 도우리 프로그램 운영","032-860-9257","0328609257","60주년 1306호"))
        departmentList.add(NumberModel("미래사회와 소프트웨어 수업, GEE 프로그램 운영","032-860-9307","0328609307","60주년 1306호"))

        //공과대학
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
        departmentList.add(NumberModel("건축학부\n(건축공학)","032-860-7580","0328607580","2남 413호"))
        departmentList.add(NumberModel("건축학부\n(건축학)","032-860-8710","0328608710","2남 413호"))
        departmentList.add(NumberModel("에너지자원공학과","032-860-7550","0328607550","2남 215호"))
        departmentList.add(NumberModel("융합기술경영학부","032-860-8871","0328608871","미래융합대학관 106호"))
        departmentList.add(NumberModel("전기공학과","032-860-7390","0328607390","하이테크센터 603호"))
        departmentList.add(NumberModel("전자공학과","032-860-7410","0328607410","하이테크센터 801호"))
        departmentList.add(NumberModel("정보통신공학과","032-860-7431","0328607431","하이테크센터 416호"))

        //자연과학대학
        departmentList.add(NumberModel("수학과","032-860-7620","0328607620","5북 211호"))
        departmentList.add(NumberModel("통계학과","032-860-7640","0328607640","5북 442B호"))
        departmentList.add(NumberModel("물리학과","032-860-7650","0328607650","5동 316호"))
        departmentList.add(NumberModel("화학과","032-860-7670","0328607670","5동 417B호"))
        departmentList.add(NumberModel("생명과학과","032-860-7690","0328607690","5북 517호"))
        departmentList.add(NumberModel("해양과학과","032-860-7700","0328607700","5북 236호"))
        departmentList.add(NumberModel("식품영양학과","032-860-8120","0328608120","본관 517호"))

        //경영대학
        departmentList.add(NumberModel("경영학과1","032-860-7730","0328607730","6호관 222호"))
        departmentList.add(NumberModel("경영학과2","032-860-7828","0328607828","6호관 222호"))
        departmentList.add(NumberModel("경영학과3","032-860-7750","0328607750","6호관 222호"))
        departmentList.add(NumberModel("글로벌금육학과","032-860-7823","0328607823","6호관 222호"))
        departmentList.add(NumberModel("아태물류학부","032-860-8222","0328608222","6호관 222호"))
        departmentList.add(NumberModel("국제통상학과","032-860-7790","0328607790","6호관 322호"))

        //사범대학
        departmentList.add(NumberModel("국어교육과","032-860-7840","0328607840","서호관 223호"))
        departmentList.add(NumberModel("영어교육과","032-860-7850","0328607850","서호관 425호"))
        departmentList.add(NumberModel("사회교육과","032-860-7860","0328607860","서호관 219호"))
        departmentList.add(NumberModel("교육학과","032-860-7870","0328607870","서호관 325호"))
        departmentList.add(NumberModel("체육교육과","032-860-7880","0328607880","서호관 416호"))
        departmentList.add(NumberModel("수학교육과","032-860-8150","0328608150","서호관 443호"))

        //사회과학대학
        departmentList.add(NumberModel("행정학과","032-860-7940","0328607940","9호관 409호"))
        departmentList.add(NumberModel("정치외교학과","032-860-7960","0328607960","9호관 409호"))
        departmentList.add(NumberModel("미디어커뮤니케이션학과","032-860-8790","0328608790","9호관 409호"))
        departmentList.add(NumberModel("경제학과","032-860-7770","0328607770","6호관 322호"))
        departmentList.add(NumberModel("소비자학과","032-860-8110","0328608110","본관 516호"))
        departmentList.add(NumberModel("아동심리학과","032-860-8140","0328608140","9호관 411호"))
        departmentList.add(NumberModel("사회복지학과","032-860-8605","0328608605","9호관 409호"))

        //문과대학
        departmentList.add(NumberModel("한국어문학과","032-860-7990","0328607990","5남 210호"))
        departmentList.add(NumberModel("사학과","032-860-8070","0328608070","5남 215호"))
        departmentList.add(NumberModel("철학과","032-860-8080","0328608080","5남 262호"))
        departmentList.add(NumberModel("중국학과","032-860-8050","0328608050","5남 269호"))
        departmentList.add(NumberModel("일본어문화학과","032-860-8060","0328608060","5남 102호"))
        departmentList.add(NumberModel("영어영문학과","032-860-8010","0328608010","5남 115호"))
        departmentList.add(NumberModel("프랑스언어문화학과","032-860-8030","0328608030","5남 414호"))
        departmentList.add(NumberModel("문화콘텐츠문화경영학과1","032-860-8040","0328608040","5남 265호"))
        departmentList.add(NumberModel("문화콘텐츠문화경영학과2","032-860-8900","0328608900","5남 265호"))

        //의과대학
        departmentList.add(NumberModel("의예과","032-860-8191","0328608191","5동 201호"))
        departmentList.add(NumberModel("간호학과","032-860-8200","0328608200","5동 301호"))

        //미래융합대학
        departmentList.add(NumberModel("메카트로닉스공학과","032-860-8871","0328608871","미래융합대학관 106호"))
        departmentList.add(NumberModel("소프트웨어융합공학과","032-860-9304","0328609304","미래융합대학관 106호"))
        departmentList.add(NumberModel("산업경영학과","032-860-9304","0328609304","미래융합대학관 106호"))
        departmentList.add(NumberModel("금융투자학과","032-860-9304","0328609304","미래융합대학관 106호"))

        //예술체육대학
        departmentList.add(NumberModel("조형예술학과","032-860-8160","0328608160","서호관 322호"))
        departmentList.add(NumberModel("디자인융합학과","032-860-8170","0328608170","서호관 125호"))
        departmentList.add(NumberModel("스포츠과학과","032-860-8180","0328608180","5서 554B호"))
        departmentList.add(NumberModel("연극영화학과","032-860-8240","0328608240","5남 242호"))
        departmentList.add(NumberModel("의류디자인학과","032-860-8130","0328608130","본관 518호"))

        //국제학부
        departmentList.add(NumberModel("IBT학과","032-860-9125","0328609125","6호관 322A호"))
        departmentList.add(NumberModel("ISE학과","032-860-9125","0328609125","6호관 322A호"))
        departmentList.add(NumberModel("KLC학과","032-860-9125","0328609125","6호관 322A호"))

        //소프트웨어융합대학
        departmentList.add(NumberModel("인공지능공학과","032-860-9440","0328609440","본관 516호"))
        departmentList.add(NumberModel("데이터사이언스학과","032-860-9440","0328609440","본관 516호"))
        departmentList.add(NumberModel("스마트모빌리티공학과","032-860-9440","0328609440","본관 516호"))
        departmentList.add(NumberModel("디자인테크놀로지학과","032-860-9440","0328609440","본관 516호"))
        departmentList.add(NumberModel("컴퓨터공학과","032-860-7440","0328607440","하이테크센터 1012호"))

        //교외
        departmentList.add(NumberModel("야생동물구조관리센터1(인천)", "032-858-9702","0328589702","연수구 송도국제대로 372번길21"))
        departmentList.add(NumberModel("야생동물구조관리센터2(인천)", "032-858-9703","0328589703","연수구 송도국제대로 372번길21"))
        departmentList.add(NumberModel("야생동물구조관리센터3(인천)", "032-858-9704","0328589704","연수구 송도국제대로 372번길21"))
        departmentList.add(NumberModel("미추홀구청", "032-887-1011","0328871011","미추홀구 동적이로95"))
        departmentList.add(NumberModel("인하대부속병원", "032-890-2114","0328902114","중구 인항로27"))
        departmentList.add(NumberModel("미추홀구 보건소1", "032-880-5455","0328805455","미추홀구 주안서로25"))
        departmentList.add(NumberModel("미추홀구 보건소2", "032-880-5456","0328805456","미추홀구 주안서로25"))
        departmentList.add(NumberModel("미추홀구 보건소3", "032-880-5457","0328805457","미추홀구 주안서로25"))
        departmentList.add(NumberModel("미추홀소방서", "032-870-3214","0328703214","미추홀구 인하로190"))
        departmentList.add(NumberModel("미추홀경찰서", "182","182","미추홀구 매소홀로290번길32"))
        departmentList.add(NumberModel("한국장학재단", "1599-2000","15992000","대구광역시 동구 신암로125"))
        departmentList.add(NumberModel("KEB하나은행\n(인하대)", "032-863-1111","0328631111","학생회관 2층"))
        departmentList.add(NumberModel("대학서적\n(인하대)", "032-868-9667","0328689667","학생회관 1층"))
        departmentList.add(NumberModel("하텍 인쇄실 2층", "010-8508-3975","01085083975","하이테크관 2층"))

    }

}