package com.oscarpino.rickandmorty

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscarpino.rickandmorty.characters.ui.view.adapter.CharacterAdapter
import com.oscarpino.rickandmorty.characters.ui.viewmodel.CharactersViewModel
import com.oscarpino.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel = CharactersViewModel()

    private val adapter = CharacterAdapter()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        observer()
        viewModel.getAllCharacters()
    }


    fun observer(){
        viewModel.characters.observe(this,{ list ->
            adapter.loadCharacters(list)
        })
    }

    fun initRecyclerView(){

    /* binding.rcvCharacters.adapter = CharacterAdapter()
     binding.rcvCharacters.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
     */
     binding.rcvCharacters.apply {
         adapter = this@MainActivity.adapter
         layoutManager =LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        }
    }
}
