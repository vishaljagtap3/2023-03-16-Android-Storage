package com.bitcodetech.storage

import android.app.Activity
import android.content.Context

object Settings {

    private val COLOR_PREF_NAME = "color_preferences"
    private val KEY_BG_COLOR = "key_bg_color"

    fun setBgColor(context: Context, color : String) {
        val prefs = context.getSharedPreferences(COLOR_PREF_NAME, Activity.MODE_PRIVATE)
        prefs.edit()
            .putString(KEY_BG_COLOR, color)
            .commit()
    }

    fun getBgColor(context: Context) : String  {
        val prefs = context.getSharedPreferences(COLOR_PREF_NAME, Activity.MODE_PRIVATE)
        return prefs.getString(KEY_BG_COLOR, "White")!!
    }

}