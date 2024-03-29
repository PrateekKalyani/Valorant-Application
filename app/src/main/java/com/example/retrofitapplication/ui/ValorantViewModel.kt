package com.example.retrofitapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapplication.domain.ValorantUseCase
import com.example.retrofitapplication.models.UiEvents
import com.example.retrofitapplication.models.ValorantAgentModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ValorantViewModel
@Inject
constructor(
    private val valorantUseCase: ValorantUseCase
) : ViewModel(){

    private val _agentsList = MutableLiveData<UiEvents<List<ValorantAgentModel>>>()
    val agentsList : LiveData<UiEvents<List<ValorantAgentModel>>>
    get() = _agentsList

    fun getAgents() {
        viewModelScope.launch {
            _agentsList.postValue(valorantUseCase.getAgents())
        }
    }

}