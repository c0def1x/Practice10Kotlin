package com.bignerdranch.android.practice10

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.luminance
import kotlin.math.absoluteValue
import kotlin.math.floor
import kotlin.math.sign
import kotlin.math.ulp
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds


class MainActivity : AppCompatActivity()
{
    private lateinit var prefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var totalCount = 0
    private lateinit var activity: ConstraintLayout

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs = getPreferences(Context.MODE_PRIVATE)
        editor = prefs.edit()
        totalCount = prefs.getInt("counter", 0)
        totalCount++
        editor.putInt("counter", totalCount).commit()

        if(totalCount == 0)
        {
            activity.setBackgroundColor(R.color.white)
        }
        else if(totalCount % 2 == 0)
        {
            activity.setBackgroundColor(R.color.blue)
        }
        else
        {
            activity.setBackgroundColor(R.color.green)
        }
    }
}