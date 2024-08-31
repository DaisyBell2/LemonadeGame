package com.daisybell.lemonadegame.game

import android.view.View
import android.widget.ImageButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.daisybell.lemonadegame.R
import com.daisybell.lemonadegame.matchers.ImageDrawableMatcher
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class ImageUi(
    countTaps: Int,
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.image),
            isAssignableFrom(ImageButton::class.java)
        )
    )

    fun assertLemonTreeImage() {
        interaction.check(matches(ImageDrawableMatcher(R.drawable.lemon_tree)))
    }

    fun assertLemonImage() {
        interaction.check(matches(ImageDrawableMatcher(R.drawable.lemon_squeeze)))
    }

    fun assertLemonadeImage() {
        interaction.check(matches(ImageDrawableMatcher(R.drawable.lemon_drink)))
    }

    fun assertEmptyGlassImage() {
        interaction.check(matches(ImageDrawableMatcher(R.drawable.lemon_restart)))
    }

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }

}
