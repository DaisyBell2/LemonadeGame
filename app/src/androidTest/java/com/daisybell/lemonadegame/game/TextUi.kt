package com.daisybell.lemonadegame.game

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.daisybell.lemonadegame.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class TextUi(
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {

    private val interaction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(R.id.labelTextView),
            isAssignableFrom(TextView::class.java)
        )
    )

    fun assertLabelTextForInitialState() {
        interaction.check(matches(withText("Tap the lemon tree to select a lemon")))
    }

    fun assertLabelTextForSqueezeLemonState() {
        interaction.check(matches(withText("Keep tapping the lemon to squeeze it")))
    }

    fun assertLabelTextForLemonadeState() {
        interaction.check(matches(withText("Tap the lemonade to drink it")))
    }

    fun assertLabelTextForEmptyGlassState() {
        interaction.check(matches(withText("Tap the empty glass to start again")))
    }

}
