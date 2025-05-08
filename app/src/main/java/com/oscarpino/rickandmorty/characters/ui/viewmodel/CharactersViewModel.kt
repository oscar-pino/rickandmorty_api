package com.oscarpino.rickandmorty.characters.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscarpino.common.Factory
import com.oscarpino.common.ResultResponse
import com.oscarpino.data.api.ApiService
import com.oscarpino.data.model.Characters
import com.oscarpino.data.repository.RepositoryImpl
import com.oscarpino.domain.GetAllCharactersUseCase
import com.oscarpino.rickandmorty.constants.Constants
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    val characters = MutableLiveData<List<Characters>>()

    private val getAllCharactersUseCase = GetAllCharactersUseCase(
        RepositoryImpl(
            Factory.apiServiceFactory(
                baseUrl = Constants.BASE_URL,
                apiClass = ApiService::class.java
            )
        )
    )

    fun getAllCharacters(){
        viewModelScope.launch{
            val response = getAllCharactersUseCase.execute()

            when(response.result){
                ResultResponse.SUCCESSFUL -> {
                    characters.postValue(response.payload ?:emptyList<Characters>())
                }
                else->{}
            }
        }
    }



}