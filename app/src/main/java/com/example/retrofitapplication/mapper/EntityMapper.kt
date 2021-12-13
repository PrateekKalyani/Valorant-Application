package com.example.retrofitapplication.mapper

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.retrofitapplication.models.Ability
import com.example.retrofitapplication.models.ValorantModel
import com.example.retrofitapplication.room.ConverterHelper
import com.example.retrofitapplication.room.ValorantEntity
import javax.inject.Inject

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    fun mapToEntity(domainModel : DomainModel) : Entity

    fun mapFromEntityList(entityList : List<Entity>) : List<DomainModel>

    fun mapToEntityList(domainModelList : List<DomainModel>) : List<Entity>
}

class CacheMapper
@Inject
constructor() : EntityMapper<ValorantEntity, ValorantModel>{
    override fun mapFromEntity(entity: ValorantEntity): ValorantModel {
        return ValorantModel(
            id = entity.id,
            image = entity.image,
            name = entity.name,
            description = entity.description,
            developerName = entity.developerName,
            abilities = entity.abilities
        )
    }

    override fun mapToEntity(domainModel: ValorantModel): ValorantEntity {
        return ValorantEntity(
            id = domainModel.id,
            image = domainModel.image,
            name = domainModel.name,
            description = domainModel.description,
            developerName = domainModel.developerName,
            abilities = domainModel.abilities
        )
    }

    override fun mapFromEntityList(entityList: List<ValorantEntity>): List<ValorantModel> {
        return entityList.map { mapFromEntity(it) }
    }

    override fun mapToEntityList(domainModelList: List<ValorantModel>): List<ValorantEntity> {
        return domainModelList.map { mapToEntity(it) }
    }

}