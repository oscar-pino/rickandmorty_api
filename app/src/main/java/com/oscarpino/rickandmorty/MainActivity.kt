package com.oscarpino.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oscarpino.rickandmorty.characters.ui.viewmodel.CharactersViewModel
import com.oscarpino.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel = CharactersViewModel()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllCharacters()
    }
}