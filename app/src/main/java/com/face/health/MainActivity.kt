package com.face.health

import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView)
        val webSettings = webView.settings
        webSettings.defaultTextEncodingName = "UTF-8"
        //属性可以让webview只显示一列，也就是自适应页面大小,不能左右滑动
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
        } else {
            webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        }
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true  // 开启 DOM storage 功能
        val appCachePath = applicationContext.cacheDir.absolutePath;
        webSettings.setAppCachePath(appCachePath)
        webSettings.allowFileAccess = true    // 可以读取文件缓存
        webSettings.setAppCacheEnabled(true)    //开启H5(APPCache)缓存功能
        webView.webViewClient = webViewClient
        webView.loadUrl("http://39.96.78.92:8012/index")
    }


    private val webViewClient = object :WebViewClient(){



        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)

        }
    }
}