package com.android.widget.square

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.uiextension.R
import com.android.uiextension.databinding.SquareMenuElementLayoutBinding

class SquareMenuElement(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private lateinit var binding: SquareMenuElementLayoutBinding

    var description: String
        get() = binding.description.text.toString()
        set(value) {
            binding.description.text = value
        }

    val icon: ImageView
        get() = binding.icon

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = SquareMenuElementLayoutBinding.bind(this)
    }

    fun setImageResource(resource: Int) = binding.icon.setImageResource(resource)

    fun setOnElementClickAction(action: () -> Unit) {
        binding.container.setOnClickListener {
            action()
        }
    }

    init {
        inflate(context, R.layout.square_menu_element_layout, this)
    }
}