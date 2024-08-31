package com.daisybell.lemonadegame

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.daisybell.lemonadegame.databinding.ActivityMainBinding

interface GameUiState {

    fun update(binding: ActivityMainBinding)

    abstract class Abstract(
        @DrawableRes private val drawableResId: Int,
        @StringRes private val stringResId: Int
    ) : GameUiState {

        override fun update(binding: ActivityMainBinding) = with(binding) {
            image.setImageResource(drawableResId)
            labelTextView.setText(stringResId)
        }
    }

    object Initial : Abstract(
        drawableResId = R.drawable.lemon_tree,
        stringResId = R.string.lemon_tree
    )

    object SqueezeLemon : Abstract(
        drawableResId = R.drawable.lemon_squeeze,
        stringResId = R.string.lemon_squeeze
    )

    object Lemonade : Abstract(
        drawableResId = R.drawable.lemon_drink,
        stringResId = R.string.lemonade
    )

    object EmptyGlass : Abstract(
        drawableResId = R.drawable.lemon_restart,
        stringResId = R.string.empty_glass
    )

}
