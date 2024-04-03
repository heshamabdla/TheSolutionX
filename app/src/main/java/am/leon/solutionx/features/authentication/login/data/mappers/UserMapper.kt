package am.leon.solutionx.features.authentication.login.data.mappers

import am.leon.solutionx.common.data.mapper.Mapper
import am.leon.solutionx.features.authentication.login.data.models.dto.PhoneDto
import am.leon.solutionx.features.authentication.login.data.models.dto.UserDto
import am.leon.solutionx.features.authentication.login.data.models.entity.UserEntity
import am.leon.solutionx.features.authentication.login.domain.models.User

internal
object UserMapper : Mapper<UserDto, User, UserEntity>() {
    override fun dtoToDomain(model: UserDto): User {
        return User(
            id = model.id ?: -1,
            userName = model.userName.orEmpty(),
            fullName = "${model.firstName.orEmpty()} ${model.lastName.orEmpty()}",
            email = model.email.orEmpty()
        )
    }

    override fun domainToEntity(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            userName = model.userName,
            fullName = model.fullName,
            email = model.email,
        )
    }

    override fun entityToDomain(model: UserEntity): User {
        return User(
            id = model.id,
            userName = model.userName,
            fullName = model.fullName,
            email = model.email
        )
    }
}