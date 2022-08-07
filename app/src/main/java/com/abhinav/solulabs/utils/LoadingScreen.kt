package com.abhinav.solulabs.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.abhinav.solulabs.R


object LoadingScreen {
    lateinit var dialog: Dialog
    private fun displayLoadingWithText(context: Context, text: String = "Loading Please wait . .  .", cancelable: Boolean = false) { // function -- context(parent (reference))
        dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_loading_screen)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(cancelable)
        val textView = dialog.findViewById<TextView>(R.id.text)
        textView.text = text
        try {
            dialog.show()
        } catch (e: Exception) {
        }
    }

    private fun hideLoading() {
        try {
            dialog.dismiss()
        } catch (e: Exception) {

        }
    }

    fun operateDialog(visibility: Boolean,context: Context, text: String = "Loading Please wait . .  .")
    {
        if(visibility)
        {
            displayLoadingWithText(context,text)
        }
        else
        {
            hideLoading()
        }

    }

}