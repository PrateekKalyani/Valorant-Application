package com.example.retrofitapplication.mapper

import com.example.retrofitapplication.models.ValorantAgentModel
import com.example.retrofitapplication.room.ValorantAgentEntity
import javax.inject.Inject

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    fun mapToEntity(domainModel : DomainModel) : Entity

    fun mapFromEntityList(entityList : List<Entity>) : List<DomainModel>

    fun mapToEntityList(domainModelList : List<DomainModel>) : List<Entity>
}

class CacheMapper
@Inject
constructor() : EntityMapper<ValorantAgentEntity, ValorantAgentModel>{
    override fun mapFromEntity(agentEntity: ValorantAgentEntity): ValorantAgentModel {
        return ValorantAgentModel(
            id = agentEntity.id,
            image = agentEntity.image,
            name = agentEntity.name,
            description = agentEntity.description,
            developerName = agentEntity.developerName,
            abilities = agentEntity.abilities
        )
    }

    override fun mapToEntity(domainAgentModel: ValorantAgentModel): ValorantAgentEntity {
        return ValorantAgentEntity(
            id = domainAgentModel.id,
            image = domainAgentModel.image,
            name = domainAgentModel.name,
            description = domainAgentModel.description,
            developerName = domainAgentModel.developerName,
            abilities = domainAgentModel.abilities
        )
    }

    override fun mapFromEntityList(agentEntityList: List<ValorantAgentEntity>): List<ValorantAgentModel> {
        return agentEntityList.map { mapFromEntity(it) }
    }

    override fun mapToEntityList(domainAgentModelList: List<ValorantAgentModel>): List<ValorantAgentEntity> {
        return domainAgentModelList.map { mapToEntity(it) }
    }

}