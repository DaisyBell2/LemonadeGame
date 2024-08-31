package com.daisybell.lemonadegame

interface GameRepository {

    fun resetSqueezeCount()
    fun next(): Int
}
