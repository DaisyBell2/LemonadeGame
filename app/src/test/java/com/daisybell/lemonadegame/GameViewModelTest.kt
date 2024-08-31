package com.daisybell.lemonadegame

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel(repository = FakeRepository())
    }

    /**
     * LGTC-01
     */
    @Test
    fun caseNumber1() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(countTaps = 2)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 1)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 0)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.Lemonade()
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.EmptyGlass()
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.Initial(countTaps = 4)
        assertEquals(expected, actual)
    }

    /**
     * LGTC-02
     */
    @Test
    fun caseNumber2() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(countTaps = 4)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 3)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 2)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 1)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 0)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.Lemonade()
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.EmptyGlass()
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.Initial(countTaps = 3)
        assertEquals(expected, actual)
    }

    /**
     * LGTC-03
     */
    @Test
    fun caseNumber3() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(countTaps = 3)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 2)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 1)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.SqueezeLemon(countTaps = 0)
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.Lemonade()
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.EmptyGlass()
        assertEquals(expected, actual)

        val actual: GameUiState = viewModel.clickImage()
        val expected: GameUiState = GameUiState.Initial(countTaps = 3)
        assertEquals(expected, actual)
    }
}

private class FakeRepository : GameRepository {

    private var countTapsFake = 0

    override fun next(countTaps: Int): Int {
        countTapsFake = countTaps
        countTapsFake--
        return countTapsFake
    }
}