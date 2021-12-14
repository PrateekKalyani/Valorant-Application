package com.example.retrofitapplication.models

import com.google.gson.annotations.SerializedName

/**
 * @param status: Defines the response status
 * @param agentsList: Defines the list of valorant agents
 */
data class ValorantRemoteResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val agentsList: List<ValorantAgentModel>
)

/**
 * @param id: Defines the agent Id
 * @param image: Defines the agent icon Image
 * @param name: Defines the agent name
 * @param description: Defines the agent description
 * @param developerName: Defines the agent developer name
 * @param abilities: Defines the abilities of the agent
 */
data class ValorantAgentModel(
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

/**
 * @param displayName: Defines the name of the ability
 * @param description: Defines the description of the ability
 * @param image: Define the icon image of the ability
 */
data class Ability(
    @SerializedName(value = "displayName")
    val displayName: String,
    @SerializedName(value = "description")
    val description: String,
    @SerializedName(value = "displayIcon")
    val image: String
)
