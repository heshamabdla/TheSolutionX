package am.leon.solutionx.features.authentication.login.data.repository.remote

import am.leon.solutionx.common.domain.repository.remote.IRestApiNetworkProvider
import am.leon.solutionx.features.authentication.login.data.models.dto.LoginDto
import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.domain.repository.remote.ILoginRemoteDS


internal class LoginRemoteDS(private val provider: IRestApiNetworkProvider) : ILoginRemoteDS {
    override suspend fun loginWithEmail(email: String, password: String): LoginDto {
        val body = hashMapOf(
            "email" to email, "password" to password
        )
        return provider.post(
            responseWrappedModel = LoginDto::class.java, pathUrl = "login",
            headers = hashMapOf("Accept-Language" to "ar"), requestBody = body
        )
    }

    override suspend fun loginWithPhone(loginRequest: LoginRequest): LoginDto {
        return provider.post(
            responseWrappedModel = LoginDto::class.java, pathUrl = "login",
            headers = hashMapOf("Accept-Language" to "ar"), requestBody = loginRequest
        )
    }
}