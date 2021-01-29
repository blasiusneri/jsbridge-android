package com.x.blas.jsbridgedemo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Build
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi

/**
 * Created by blasius.n.puspika on 29/01/21.
 */
class MainApplication : Application() {
    var mapperWebView: WebView? = null
    var webViewClient: WebViewClient? = null

    companion object {

        fun getInstance(context: Context): MainApplication =
            context.applicationContext as MainApplication
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate() {
        super.onCreate()
        mapperWebView = WebView(this)
        mapperWebView?.settings?.javaScriptEnabled = true
        mapperWebView?.addJavascriptInterface(JsMapperInterface(this), "JsMapperInterface")
        mapperWebView?.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String?) {
                mapperWebView?.evaluateJavascript("sendToastMessage()", null)
            }
        }
        mapperWebView?.loadUrl("file:///android_asset/mapper.html")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun mappingToastMessage(toast: String) {
        mapperWebView?.evaluateJavascript("sendToastMessage()", null)
    }
}