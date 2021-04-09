package com.mengchea.theme_switcher

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat

class ThemeSwitcher : SwitchCompat {

    internal var context: Context
    private var themeStyle: Int = 1
    private var trackDayColor: Int = 0
    private var trackNightColor: Int = 0

    constructor(context: Context) : super(context) {
        this.context = context
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        this.context = context
        val style: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ThemeSwitcher)
        themeStyle = style.getInt(R.styleable.ThemeSwitcher_themeStyle, 1)
        val defDayColor = ResourcesCompat.getColor(resources, R.color.color_light, null)
        val defNightColor = ResourcesCompat.getColor(resources, R.color.color_dark, null)
        trackDayColor = style.getColor(R.styleable.ThemeSwitcher_trackDayColor, defDayColor)
        trackNightColor = style.getColor(R.styleable.ThemeSwitcher_trackNightColor, defNightColor)
        style.recycle()
        initTheme()
    }

    constructor(context: Context, attrs: AttributeSet, defAttr: Int) : super(context, attrs, defAttr){
        this.context = context
    }

    private fun initTheme() {
        when (themeStyle) {
            1 -> thumbDrawable = ResourcesCompat.getDrawable(resources, R.drawable.thumb_switcher, null)
            2 -> thumbDrawable = ResourcesCompat.getDrawable(resources, R.drawable.thumb2_switcher, null)
        }

        trackDrawable = setColor(context, R.drawable.track_switcher)

        background = null

    }

    private fun setColor(context: Context, @DrawableRes resId: Int): Drawable {
        val drawable = AppCompatResources.getDrawable(context, resId)
        val drawableCompat = DrawableCompat.unwrap<Drawable>(drawable!!)
        val colorState = ColorStateList(
                arrayOf(intArrayOf(-android.R.attr.state_checked),
                        intArrayOf(android.R.attr.state_checked)
                ), intArrayOf(trackDayColor, trackNightColor)
        )
        DrawableCompat.setTintList(drawableCompat, colorState)
        return drawable
    }

}