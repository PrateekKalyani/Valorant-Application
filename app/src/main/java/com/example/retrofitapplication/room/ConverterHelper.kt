package com.example.retrofitapplication.room

import androidx.room.TypeConverter
import com.example.retrofitapplication.models.Ability
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConverterHelper {

    @TypeConverter
    fun stringToObjectList(value: String): ArrayList<Ability> {
        val listType = object : TypeToken<ArrayList<Ability?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listOfObjectToString(list: List<Ability>): String {
        return Gson().toJson(list).toString()
    }
}