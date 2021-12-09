package com.han.inhauniversityphonebook

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.han.inhauniversityphonebook.adapter.DepartmentAdapter
import com.han.inhauniversityphonebook.department.*
import com.han.inhauniversityphonebook.model.NumberModel
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private val filterRecyclerView: RecyclerView by lazy {
        findViewById(R.id.departmentRecyclerView)
    }
    //오리가 말하는 곳임 eidtText에 들어온 말
    private val textView: TextView by lazy {
        findViewById(R.id.textView)
    }
    private val backButton: AppCompatButton by lazy {
        findViewById(R.id.backButton)
    }
    //즐겨찾기 오리버튼 -나중에 구현
    private val favoriteButton: ImageButton by lazy {
        findViewById(R.id.favoriteDuckButton)
    }
    private val numberFindEditText: EditText by lazy {
        findViewById(R.id.numberFindEditText)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = FragmentHome()
        val fragment0 = Fragment0()
        val fragmentSearch = FragmentSearch()

        replaceFragment(fragmentSearch)
        replaceFragment(fragmentHome)

        numberFindEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                val text = numberFindEditText.text.toString()
                    .lowercase(Locale.getDefault())

                if(text.isNotEmpty()){
                    fragmentSearch.departmentAdapter?.filter(text)
                    replaceFragment(fragmentSearch)
                }else{
                    replaceFragment(fragment0)
                }
            }

        })
        numberFindEditText.setOnEditorActionListener { textView, action, keyEvent ->
            var handled = false
            if(action == EditorInfo.IME_ACTION_DONE){
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(numberFindEditText.windowToken, 0)
                handled = true
            }
            handled
        }

    }
    override fun onBackPressed() {
        val backDialog = BackCustomDialog(finishApp = {finish()})
        backDialog.show(supportFragmentManager, "BackDialog")
    }


    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.frameLayout, fragment)
                commit()
            }
    }

}