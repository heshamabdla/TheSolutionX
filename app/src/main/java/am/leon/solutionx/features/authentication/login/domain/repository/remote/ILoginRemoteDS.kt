package am.leon.solutionx.features.authentication.login.domain.repository.remote

import am.leon.solutionx.features.authentication.login.data.models.dto.LoginDto
import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest

// I --> interface  [feature]  layer

internal interface ILoginRemoteDS {
    suspend fun loginWithEmail(email: String, password: String): LoginDto
    suspend fun loginWithPhone(loginRequest: LoginRequest): LoginDto
}