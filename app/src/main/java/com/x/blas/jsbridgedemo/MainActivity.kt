package com.x.blas.jsbridgedemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
  var webView: WebView? = null

  @SuppressLint("SetJavaScriptEnabled")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    webView = findViewById(R.id.wv_main)

    webView?.loadUrl("file:///android_asset/index.html")
    webView?.settings?.javaScriptEnabled = true
    webView?.addJavascriptInterface(JsInterface(this), "JsInterface")
  }
}