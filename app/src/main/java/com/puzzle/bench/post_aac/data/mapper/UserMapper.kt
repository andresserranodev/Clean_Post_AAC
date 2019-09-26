package com.puzzle.bench.post_aac.data.mapper

import com.puzzle.bench.post_aac.data.database.entity.UserEntity
import com.puzzle.bench.post_aac.data.networking.responses.UserResponse
import com.puzzle.bench.post_aac.model.User

class UserMapper : BaseMapperData<UserResponse, UserEntity, User> {

    override fun transformServiceToEntity(service: UserResponse) = UserEntity(
        service.userId, service.name, service.email, service.phone, service.website

    )

    override fun transformEntityToPresentation(entity: UserEntity) =
        User(entity.userId, entity.name, entity.email, entity.phone, entity.website)
}