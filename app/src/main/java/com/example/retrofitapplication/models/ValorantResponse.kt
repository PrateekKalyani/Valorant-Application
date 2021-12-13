package com.example.retrofitapplication.models

sealed class ValorantResponse{
    data class Success(val result: List<ValorantModel>) : ValorantResponse()
    data class Error(val error: String) : ValorantResponse()
    object Loading : ValorantResponse()
}
