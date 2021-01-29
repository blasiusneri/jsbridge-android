package com.x.blas.jsbridgedemo

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

/**
 * Created by blasius.n.puspika on 29/01/21.
 */
class JsMapperInterface(private val context: Context) {

  @JavascriptInterface
  fun showMapperToast(message: String) {
    Toast.makeText(context, "Hello Mapper $message", Toast.LENGTH_SHORT).show()
  }
}