package com.oscarpino.data.api

import com.oscarpino.data.model.CharactersResponse
import retrofit2.http.GET

interface ApiService {

   @GET("api/character")
   suspend fun getAllCharacters(): CharactersResponse
}