package com.mengchea.theme_switcher

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.res.ResourcesCompat

class ThemeSwitcher : SwitchCompat {

    internal var context: Context

    init {
        initTheme()
    }

    constructor(context: Context) : super(context) {
        this.context = context
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr){
        this.context = context
    }

    constructor(context: Context, attr: AttributeSet, defAttr: Int) : super(context, attr, defAttr){
        this.context = context
    }

    private fun initTheme(){
        thumbDrawable = ResourcesCompat.getDrawable(resources, R.drawable.thumb_switcher, null)
        trackDrawable = ResourcesCompat.getDrawable(resources, R.drawable.track_switcher, null)
    }

}