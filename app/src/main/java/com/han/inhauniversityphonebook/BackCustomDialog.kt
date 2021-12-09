package com.han.inhauniversityphonebook

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import com.han.inhauniversityphonebook.databinding.BackDialogBinding
import kotlin.math.log

class BackCustomDialog(val finishApp: ()->Unit): DialogFragment() {
    private var binding: BackDialogBinding? = null
    private val logoutText = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initLogoutText()
        binding = BackDialogBinding.inflate(inflater, container, false)
        val view = binding!!.root
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding!!.homeBackButton.setOnClickListener {
            dialog!!.dismiss()
        }
        binding!!.logoutButton.setOnClickListener {
            Toast.makeText(context, logoutText.random(), Toast.LENGTH_SHORT).show()
            finishApp()
        }

        return view
    }



    private fun initLogoutText() {
        logoutText.clear()
        logoutText.add("인-바")
        logoutText.add("인덕이: 빠이")
        logoutText.add("안뇽이: 빠이")
        logoutText.add("이용해주셔서 감사합니다 !")
        logoutText.add("추가할 번호가 있다면 알려주세요!")
    }

    override fun onResume() {
        super.onResume()
        val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceWidth = size.x
        params?.width = (deviceWidth * 0.9).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

}