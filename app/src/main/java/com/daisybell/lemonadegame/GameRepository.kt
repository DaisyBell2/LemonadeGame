package com.daisybell.lemonadegame

interface GameRepository {

    fun resetSqueezeCount()
    fun next(): Int

    class Base() : GameRepository {

        private var currentStep = 0
        private var squeezeCount = 0

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
}
