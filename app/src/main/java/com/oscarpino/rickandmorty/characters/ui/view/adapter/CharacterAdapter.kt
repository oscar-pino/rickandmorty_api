package com.oscarpino.rickandmorty.characters.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.oscarpino.data.model.Characters
import com.oscarpino.rickandmorty.R
import com.oscarpino.rickandmorty.constants.Constants
import com.oscarpino.rickandmorty.databinding.ItemCharacterBinding

class CharacterAdapter(): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val charactersList = mutableListOf<Characters>()

    fun loadCharacters(charactersList:List<Characters>){
        this.charactersList.clear()
        this.charactersList.addAll(charactersList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {

        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CharacterViewHolder,
        position: Int
    ) {
        val character = charactersList[position]
        holder.bind(character)

    }

    override fun getItemCount() = charactersList.size


    class CharacterViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(character:Characters){

            binding.name.setText(character.name)
            binding.subtitle.setText(character.type)
            setImage(character.image)
            setGender(character.gender)
        }

        fun setImage(url:String){
            Glide.with(binding.root.context)
                .load(url)
                .circleCrop()
                .into(binding.imageCharacter)
        }

        fun setGender(gender:String){
            val id = when(gender){
                "Female"->{R.drawable.female}
                "Male"->{R.drawable.male}
                else->{R.drawable.ic_launcher_foreground}
            }
            binding.imgGender.setImageResource(id)
        }
    }
}

