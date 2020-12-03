package com.android.widget.square

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

open class SquareMenu(context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context, attrs) {

    fun prepareElement(element: SquareMenuElement, name: String, iconRes: Int, action: () -> Unit) {
        element.apply {
            description = name
            icon.setImageResource(iconRes)
            setOnElementClickAction(action)
        }
    }
}