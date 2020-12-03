package com.android.widget.square

import android.content.Context
import android.util.AttributeSet
import com.android.uiextension.R
import com.android.uiextension.databinding.SquareMenuSixLayoutBinding

class SquareMenuSix(context: Context, attrs: AttributeSet? = null) : SquareMenu(context, attrs) {

    //view binding
    private lateinit var binding: SquareMenuSixLayoutBinding

    override fun onFinishInflate() {
        super.onFinishInflate()
        //view binding
        binding = SquareMenuSixLayoutBinding.bind(this)
    }

    fun prepareFirstElement(name: String, iconRes: Int, action: () -> Unit) = prepareElement(binding.first, name, iconRes, action)

    fun prepareSecondElement(name: String, iconRes: Int, action: () -> Unit) = prepareElement(binding.second, name, iconRes, action)

    fun prepareThirdElement(name: String, iconRes: Int, action: () -> Unit) = prepareElement(binding.third, name, iconRes, action)

    fun prepareFourthElement(name: String, iconRes: Int, action: () -> Unit) = prepareElement(binding.fourth, name, iconRes, action)

    fun prepareFifthElement(name: String, iconRes: Int, action: () -> Unit) = prepareElement(binding.fifth, name, iconRes, action)

    fun prepareSixthElement(name: String, iconRes: Int, action: () -> Unit) = prepareElement(binding.sixth, name, iconRes, action)


    init {
        inflate(context, R.layout.square_menu_six_layout, this)
    }
}