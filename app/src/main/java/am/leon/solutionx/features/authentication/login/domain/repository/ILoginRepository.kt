package am.leon.solutionx.features.authentication.login.domain.repository

import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.domain.models.Login
import am.leon.solutionx.features.authentication.login.domain.models.User

interface ILoginRepository {
    suspend fun loginWithEmail(email: String, password: String): Login
    suspend fun loginWithPhone(loginRequest: LoginRequest): Login
    suspend fun saveLogin(login: Login)

    suspend fun getUser(): User

}