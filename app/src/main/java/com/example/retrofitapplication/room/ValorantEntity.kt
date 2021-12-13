package com.example.retrofitapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.retrofitapplication.models.Ability
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ValorantTable")
data class ValorantEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name  = "id")
    val id: String,
    @ColumnInfo(name  = "image")
    val image: String,
    @ColumnInfo(name  = "name")
    val name: String,
    @ColumnInfo(name  = "description")
    val description: String,
    @ColumnInfo(name  = "developerName")
    val developerName: String,
    @ColumnInfo(name  = "abilities")
    val abilities: List<Ability>
)
