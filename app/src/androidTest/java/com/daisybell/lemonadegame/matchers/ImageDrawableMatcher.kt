package com.daisybell.lemonadegame.matchers

import android.view.View
import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.toBitmap
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

/**
 * @author DaisyBell on 31.08.2024
 */
class ImageDrawableMatcher(@DrawableRes private val drawableResId: Int) :
    BoundedMatcher<View, ImageButton>(ImageButton::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("Drawable for imageButton doesn't match expected $drawableResId")
    }

    override fun matchesSafely(item: ImageButton): Boolean {
        val context = item.context
        val expectedBitmap = context.getDrawable(drawableResId)?.toBitmap()

        return item.drawable.toBitmap().sameAs(expectedBitmap)
    }
}