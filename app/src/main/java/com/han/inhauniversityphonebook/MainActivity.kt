package com.han.inhauniversityphonebook

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.han.inhauniversityphonebook.department.*


class MainActivity : AppCompatActivity() {

    private var isDouble = false


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = FragmentHome()
        replaceFragment(fragmentHome)
    }
    override fun onBackPressed() {
        createBackDialog()
    }

    private fun createBackDialog(){
        val backDialog = LayoutInflater.from(this).inflate(R.layout.back_dialog,null)
        val homeButton = backDialog.findViewById<ImageButton>(R.id.homeBackButton)
        val logoutButton = backDialog.findViewById<ImageView>(R.id.logoutButton)

        AlertDialog.Builder(this)
            .setView(backDialog)
            .show()
            .also { alertDialog ->
                homeButton.setOnClickListener {
                    alertDialog.dismiss()
                }
                logoutButton.setOnClickListener {
                    finish()
                }
            }

    }
    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.frameLayout, fragment)
                commit()
            }
    }


}