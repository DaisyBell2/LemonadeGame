package com.daisybell.lemonadegame.game

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.daisybell.lemonadegame.R
import org.hamcrest.Matcher

/**
 * @author DaisyBell on 31.08.2024
 */
class GamePage() {

    // region fields
    private val containerIdMatcher: Matcher<View> = withParent(withId(R.id.rootLayout))

    private val containerClassTypeMatcher: Matcher<View> =
        withParent(isAssignableFrom(LinearLayout::class.java))

    private val imageUi = ImageUi(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )

    private val textUi = TextUi(
        containerIdMatcher = containerIdMatcher,
        containerClassTypeMatcher = containerClassTypeMatcher
    )
    //endregion

    fun assertInitialState() {
        imageUi.assertLemonTreeImage()
        textUi.assertLabelTextForInitialState()
    }

    fun clickImage() {
        imageUi.click()
    }

    fun assertSqueezeLemonState() {
        imageUi.assertLemonImage()
        textUi.assertLabelTextForSqueezeLemonState()
    }

    fun assertLemonadeState() {
        imageUi.assertLemonadeImage()
        textUi.assertLabelTextForLemonadeState()
    }

    fun assertEmptyGlassState() {
        imageUi.assertEmptyGlassImage()
        textUi.assertLabelTextForEmptyGlassState()
    }

}