package com.example.retrofitapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapplication.domain.ValorantUseCase
import com.example.retrofitapplication.models.UiEvents
import com.example.retrofitapplication.models.ValorantModel
import com.example.retrofitapplication.models.ValorantResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ValorantViewModel
@Inject
constructor(
    private val valorantUseCase: ValorantUseCase
) : ViewModel(){

    private val _agentsList = MutableLiveData<UiEvents<List<ValorantModel>>>()
    val agentsList : LiveData<UiEvents<List<ValorantModel>>>
    get() = _agentsList

    fun getAgents() {
        viewModelScope.launch {

            when(val response = valorantUseCase.getAgents()) {

                is ValorantResponse.Success -> {
                    _agentsList.postValue(UiEvents.Success(result = response.result))
                }

                is ValorantResponse.Error -> {
                    _agentsList.postValue(UiEvents.Error(response.error))
                }

                is ValorantResponse.Loading -> {

                }
            }
        }
    }

}