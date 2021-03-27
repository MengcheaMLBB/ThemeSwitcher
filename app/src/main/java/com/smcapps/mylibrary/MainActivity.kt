package com.smcapps.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.mengchea.theme_switcher.ThemeSwitcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switcher = findViewById<ThemeSwitcher>(R.id.theme_switcher)

        switcher.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked)
                Snackbar.make(compoundButton, "Switch to Dark", Snackbar.LENGTH_SHORT).show()
            else
                Snackbar.make(compoundButton, "Switch to Light", Snackbar.LENGTH_SHORT).show()
        }

    }
    
}