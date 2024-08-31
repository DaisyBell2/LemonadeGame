package com.daisybell.lemonadegame

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel
    private lateinit var repository: FakeRepository

    @Before
    fun setup() {
        repository = FakeRepository()
        viewModel = GameViewModel(repository = repository)
    }

    /**
     * LGTC-01
     */
    @Test
    fun caseNumber1() {
        var actual: GameUiState = viewModel.init()
        repository.squeezeCount(count = 2)
        var expected: GameUiState = GameUiState.Initial
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.Lemonade
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.EmptyGlass
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        repository.squeezeCount(count = 3)
        expected = GameUiState.Initial
        assertEquals(expected, actual)
    }

    /**
     * LGTC-02
     */
    @Test
    fun caseNumber2() {
        var actual: GameUiState = viewModel.init()
        repository.squeezeCount(count = 4)
        var expected: GameUiState = GameUiState.Initial
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.Lemonade
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.EmptyGlass
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        repository.squeezeCount(count = 3)
        expected = GameUiState.Initial
        assertEquals(expected, actual)
    }

    /**
     * LGTC-03
     */
    @Test
    fun caseNumber3() {
        var actual: GameUiState = viewModel.init()
        repository.squeezeCount(count = 3)
        var expected: GameUiState = GameUiState.Initial
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.SqueezeLemon
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.Lemonade
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        expected = GameUiState.EmptyGlass
        assertEquals(expected, actual)

        actual = viewModel.clickImage()
        repository.squeezeCount(count = 2)
        expected = GameUiState.Initial
        assertEquals(expected, actual)
    }
}

private class FakeRepository : GameRepository {

    private var currentStep = 0
    private var squeezeCount = 0

    fun squeezeCount(count: Int): Int {
        squeezeCount = count
        return squeezeCount
    }

    override fun resetSqueezeCount() {
        squeezeCount = (2..4).random()
    }

    override fun next(): Int {
        when (currentStep) {
            0 -> currentStep++
            1 -> {
                if (squeezeCount > 0) squeezeCount--
                if (squeezeCount == 0) currentStep++
            }

            2 -> currentStep++
            3 -> currentStep = 0
        }
        return currentStep
    }

}