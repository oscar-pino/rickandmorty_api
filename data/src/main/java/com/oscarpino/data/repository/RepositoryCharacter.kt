package com.oscarpino.data.repository

import com.oscarpino.common.BaseResponse
import com.oscarpino.data.model.Characters

interface RepositoryCharacter {

   suspend fun getCharacters(): BaseResponse<List<Characters>>

    fun getCharacterById(id:Int):Characters

    fun createCharacter(character:Characters):Characters

    fun updateCharacter(id:Int, character:Characters):Characters

    fun deleteCharacterById(id:Int):Characters
}