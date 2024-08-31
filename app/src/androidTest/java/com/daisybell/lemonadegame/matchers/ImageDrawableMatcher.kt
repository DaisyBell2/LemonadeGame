package com.daisybell.lemonadegame.matchers

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.toBitmap
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

/**
 * @author DaisyBell on 31.08.2024
 */
class ImageDrawableMatcher(@DrawableRes private val drawableResId: Int) :
    BoundedMatcher<View, ImageView>(ImageView::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("Drawable for imageView doesn't match expected $drawableResId")
    }

    override fun matchesSafely(item: ImageView): Boolean {
        val context = item.context
        val expectedBitmap = context.getDrawable(drawableResId)?.toBitmap()

        return item.drawable.toBitmap().sameAs(expectedBitmap)
    }
}