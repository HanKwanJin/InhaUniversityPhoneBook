package com.han.inhauniversityphonebook

import android.content.ClipData
import android.content.ClipboardManager
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
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.han.inhauniversityphonebook.databinding.BackDialogBinding
import com.han.inhauniversityphonebook.databinding.CallDialogBinding
import com.han.inhauniversityphonebook.model.NumberModel

class CallCustomDialog(private val name: String ,private val numberForCopy: String, private val callNumber:String, private val location:String): DialogFragment() {
    private var binding: CallDialogBinding? = null
    private val copyText = mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initCopyText()
        binding = CallDialogBinding.inflate(inflater, container, false)
        val view = binding!!.root
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding!!.departmentNameTextView.text = name
        binding!!.dialogNumberTextView.text = numberForCopy
        binding!!.locationTextView.text = location


        binding!!.callIconButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$callNumber"))
            startActivity(intent)

        }

        binding!!.copyIconButton.setOnClickListener {

            (requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).apply {
                setPrimaryClip(ClipData.newPlainText("INHA", numberForCopy))
                Toast.makeText(context, copyText.random(), Toast.LENGTH_SHORT).show()
            }

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
        params?.width = (deviceWidth * 0.9).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    private fun initCopyText() {
        copyText.clear()
        copyText.add("인덕이가 번호를 기억했어요.")
        copyText.add("괴도 인덕이가 번호를 훔쳐갔어요\uD83E\uDD2B")
        copyText.add("앗! 야생의 인덕(이)가 번호를 복사했다!")
        copyText.add("다음은 당신의 마음 차례입니다.")
    }
}