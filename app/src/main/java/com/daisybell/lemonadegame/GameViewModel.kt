package com.daisybell.lemonadegame

class GameViewModel(private val repository: GameRepository) {

    fun init(): GameUiState {
        repository.resetSqueezeCount()
        return GameUiState.Initial
    }

    fun clickImage(): GameUiState {
        val nextStep = repository.next()
        return when (nextStep) {
            1 -> GameUiState.SqueezeLemon
            2 -> GameUiState.Lemonade
            3 -> GameUiState.EmptyGlass
            else -> init()
        }
    }

}
