package com.daisybell.lemonadegame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.daisybell.lemonadegame.game.GamePage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var gamePage: GamePage

    /**
     * LGTC-01
     */
    @Test
    fun caseNumber1() {
        gamePage = GamePage(countTaps = 2)
        gamePage.assertInitialState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertLemonadeState()

        gamePage.clickImage()
        gamePage.assertEmptyGlassState()

        gamePage.clickImage()
        gamePage.assertInitialState()
    }

    /**
     * LGTC-02
     */
    @Test
    fun caseNumber2() {
        gamePage = GamePage(countTaps = 4)
        gamePage.assertInitialState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertLemonadeState()

        gamePage.clickImage()
        gamePage.assertEmptyGlassState()

        gamePage.clickImage()
        gamePage.assertInitialState()
    }

    /**
     * LGTC-03
     */
    @Test
    fun caseNumber3() {
        gamePage = GamePage(countTaps = 3)
        gamePage.assertInitialState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertSqueezeLemonState()

        gamePage.clickImage()
        gamePage.assertLemonadeState()

        gamePage.clickImage()
        gamePage.assertEmptyGlassState()

        gamePage.clickImage()
        gamePage.assertInitialState()
    }
}