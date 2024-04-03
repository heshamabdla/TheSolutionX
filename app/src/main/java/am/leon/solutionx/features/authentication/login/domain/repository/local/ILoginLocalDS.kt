package am.leon.solutionx.features.authentication.login.domain.repository.local

import am.leon.solutionx.features.authentication.login.data.models.entity.LoginEntity
import am.leon.solutionx.features.authentication.login.data.models.entity.UserEntity

// I --> interface  [feature]  layer

internal interface ILoginLocalDS {
    suspend fun saveLogin(login: LoginEntity)
    suspend fun getUser(): UserEntity
    suspend fun getAccessToken(): String
}