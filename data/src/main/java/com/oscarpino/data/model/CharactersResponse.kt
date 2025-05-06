package com.oscarpino.data.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(@SerializedName("results") val characters:List<Characters>)