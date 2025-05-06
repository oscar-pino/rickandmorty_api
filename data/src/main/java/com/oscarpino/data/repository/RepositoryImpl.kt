package com.oscarpino.data.repository

import com.oscarpino.common.BaseResponse
import com.oscarpino.common.ResultResponse
import com.oscarpino.data.api.ApiService
import com.oscarpino.data.model.Characters

class RepositoryImpl(private val apiService: ApiService) : RepositoryCharacter {

    override suspend fun getCharacters(): BaseResponse<List<Characters>> {

      return  try {
          val response = apiService.getAllCharacters()
             BaseResponse(result = ResultResponse.SUCCESSFUL, payload = response.characters)
        } catch (e: Exception){
             BaseResponse(result = ResultResponse.ERROR, null)
        }
    }

    override fun getCharacterById(id: Int): Characters {
        return Characters()
    }

    override fun createCharacter(character: Characters): Characters {
        return Characters()    }

    override fun updateCharacter(
        id: Int,
        character: Characters
    ): Characters {
        return Characters()
    }

    override fun deleteCharacterById(id: Int): Characters {
        return Characters()
    }
}