package com.thanht.watatesting.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import kotlin.random.Random

@SuppressLint("WrongConstant")
fun hideKeyboard(activity: Activity) {
    try {
        val inputManager = activity.getSystemService("input_method") as InputMethodManager
        inputManager.hideSoftInputFromWindow(activity.currentFocus?.applicationWindowToken, 2)
    } catch (var2: Exception) {
        var2.printStackTrace()
    }
}

fun Context.getSystemWidth(): Int {
    val wm = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val metrics = DisplayMetrics()
    display.getMetrics(metrics)
    return metrics.widthPixels
}

fun getRandom(from: Int, to: Int): Int {
    return Random.nextInt(from, to)
}