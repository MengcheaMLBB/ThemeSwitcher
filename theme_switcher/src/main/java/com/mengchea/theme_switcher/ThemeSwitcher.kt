package com.mengchea.theme_switcher

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.res.ResourcesCompat


class ThemeSwitcher : SwitchCompat {

    internal var context: Context
    private var themeStyle: Int = 1

    constructor(context: Context) : super(context) {
        this.context = context
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        this.context = context
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ThemeSwitcher)
        themeStyle = a.getInt(R.styleable.ThemeSwitcher_themeStyle, 1)
        a.recycle()
        initTheme()
    }

    constructor(context: Context, attrs: AttributeSet, defAttr: Int) : super(context, attrs, defAttr){
        this.context = context
    }

    private fun initTheme() {
        when (themeStyle) {
            1 -> {
                thumbDrawable = ResourcesCompat.getDrawable(resources, R.drawable.thumb_switcher, null)
            }
            2 -> {
                thumbDrawable = ResourcesCompat.getDrawable(resources, R.drawable.thumb2_switcher, null)
            }
        }
        trackDrawable = ResourcesCompat.getDrawable (resources, R.drawable.track_switcher, null)
    }
}