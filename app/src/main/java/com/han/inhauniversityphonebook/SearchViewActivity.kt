package com.han.inhauniversityphonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SearchViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl("https://www.inha.ac.kr/kr/968/subview.do")
    }
}