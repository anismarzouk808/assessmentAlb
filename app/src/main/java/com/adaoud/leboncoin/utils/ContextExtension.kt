package com.adaoud.leboncoin.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.ConnectivityManager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.adaoud.leboncoin.MyApplication


val Context.activityContext: Activity?
    get() = findActivityContext()

private fun Context.findActivityContext(): Activity? {
    var context = this
    while (true) {
        when (context) {
            is Activity -> return context
            is ContextWrapper -> context = context.baseContext
            else -> return null
        }
    }
}

fun Context.inflate(resource: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false) = LayoutInflater.from(this).inflate(resource, parent, attachToRoot)

val Context.connectivityManager: ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


/*
val Activity.injector
    get() = (application as MyApplication).injector

val Fragment.injector
    get() = (requireContext().applicationContext as MyApplication).injector*/

fun Context.convertDpToPixel(dp: Int): Int {
    val metrics = this.resources.displayMetrics
    return dp * metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT
}

fun Context.convertPixelToDp(px: Int): Int {
    val metrics = this.resources.displayMetrics
    return px / metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG) = Toast.makeText(this, message, duration).show()
fun Context.toast(messageRes: Int, duration: Int = Toast.LENGTH_LONG) = Toast.makeText(this, messageRes, duration).show()
