package com.mayank.kotlinbasic

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 *  As you can see, we didn’t have to put our hideKeyboard() method under some top-level class declaration.
 *  Kotlin, on compilation, will create a class with the name 'Utility.kt' and will place the method inside it.
 */

/**
 *  Function for Hiding soft keyboard
 */
fun hideKeyboard(activity: Activity) {
    val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    //Find the currently focused view, so we can grab the correct window token from it.
    var view = activity.currentFocus
    //If no view currently has focus, create a new one, just so we can grab a window token from it
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}