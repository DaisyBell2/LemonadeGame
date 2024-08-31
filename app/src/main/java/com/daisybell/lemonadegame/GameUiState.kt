package com.daisybell.lemonadegame

import com.daisybell.lemonadegame.databinding.ActivityMainBinding

interface GameUiState {

    fun update(binding: ActivityMainBinding) {}

    object Initial : GameUiState {

    }

    object SqueezeLemon : GameUiState {

    }

    object Lemonade : GameUiState {

    }

    object EmptyGlass : GameUiState {

    }

}
