package com.oscarpino.domain

import com.oscarpino.common.BaseResponse
import com.oscarpino.data.model.Characters
import com.oscarpino.data.repository.RepositoryCharacter

class GetAllCharactersUseCase(private val repository: RepositoryCharacter) {

    suspend fun execute(): BaseResponse<List<Characters>>{
        return repository.getCharacters()
    }
}