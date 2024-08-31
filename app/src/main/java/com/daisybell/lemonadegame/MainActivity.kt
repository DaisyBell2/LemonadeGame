package com.daisybell.lemonadegame

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.daisybell.lemonadegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel: GameViewModel = GameViewModel(object : GameRepository {
            override fun currentStep(): Int {
                TODO("Not yet implemented")
            }

            override fun squeezeCount(count: Int): Int {
                TODO("Not yet implemented")
            }

            override fun next(): Int {
                TODO("Not yet implemented")
            }

        })

        binding.image.setOnClickListener {
            val uiState: GameUiState = viewModel.clickImage()
            uiState.update(binding = binding)
        }

        val uiState: GameUiState = viewModel.init()
        uiState.update(binding = binding)
    }
}