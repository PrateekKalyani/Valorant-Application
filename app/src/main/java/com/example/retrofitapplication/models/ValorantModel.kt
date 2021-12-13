package com.example.retrofitapplication.models

import com.google.gson.annotations.SerializedName

data class ValorantRemoteResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val agentsList: List<ValorantModel>
)

data class ValorantModel(
    @SerializedName(value = "uuid")
    val id: String,
    @SerializedName(value = "displayIcon")
    val image: String,
    @SerializedName(value = "displayName")
    val name: String,
    @SerializedName(value = "description")
    val description: String,
    @SerializedName(value ="developerName")
    val developerName: String,
    @SerializedName(value = "abilities")
    val abilities: List<Ability>
)

data class Ability(
    @SerializedName(value = "displayName")
    val displayName: String,
    @SerializedName(value = "description")
    val description: String,
    @SerializedName(value = "displayIcon")
    val image: String
)
