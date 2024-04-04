package am.leon.solutionx.features.authentication.login.domain.repository.local

import am.leon.solutionx.features.authentication.login.data.models.entity.LoginEntity
import am.leon.solutionx.features.authentication.login.data.models.entity.UserEntity


internal interface ILoginLocalDS {
    suspend fun saveLogin(login: LoginEntity)
    suspend fun getUser(): UserEntity
    suspend fun getAccessToken(): String
}