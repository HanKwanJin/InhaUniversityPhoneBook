package com.han.inhauniversityphonebook

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.han.inhauniversityphonebook.databinding.ContactDialogBinding

class CustomContact: DialogFragment() {
    private var binding: ContactDialogBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContactDialogBinding.inflate(inflater, container, false)
        val view = binding!!.root
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding!!.backButton.setOnClickListener {
            dialog!!.dismiss()
        }
        binding!!.contactButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://pf.kakao.com/_gXhxbb/chat")
            startActivity(intent)
        }
        return view


    }

    override fun onResume() {
        super.onResume()
        val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceWidth = size.x
        val deviceHeight = size.y

        params?.width = (deviceWidth * 0.9).toInt()
        params?.height = (deviceHeight * 0.3).toInt()

        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }
}