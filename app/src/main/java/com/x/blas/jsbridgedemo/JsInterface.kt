package com.x.blas.jsbridgedemo

import android.content.Context
import android.webkit.JavascriptInterface

/**
 * Created by blasius.n.puspika on 29/01/21.
 */
class JsInterface(private val context: Context) {

  @JavascriptInterface
  fun sendToast(message: String) {
    MainApplication.getInstance(context).mappingToastMessage(message)
  }
}