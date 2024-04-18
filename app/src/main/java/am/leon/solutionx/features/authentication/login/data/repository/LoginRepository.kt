package am.leon.solutionx.features.authentication.login.data.repository

import am.leon.solutionx.features.authentication.login.data.mappers.LoginMapper
import am.leon.solutionx.features.authentication.login.data.mappers.UserMapper
import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.domain.models.Login
import am.leon.solutionx.features.authentication.login.domain.models.User
import am.leon.solutionx.features.authentication.login.domain.repository.ILoginRepository
import am.leon.solutionx.features.authentication.login.domain.repository.local.ILoginLocalDS
import am.leon.solutionx.features.authentication.login.domain.repository.remote.ILoginRemoteDS

internal class LoginRepository(
    private val remoteDS: ILoginRemoteDS, private val localDS: ILoginLocalDS
) : ILoginRepository {
    override suspend fun loginWithEmail(email: String, password: String): Login {
        val result = remoteDS.loginWithEmail(email, password)
        return LoginMapper.dtoToDomain(result)
    }

    override suspend fun loginWithPhone(loginRequest: LoginRequest): Login {
        val result = remoteDS.loginWithPhone(loginRequest)
        return LoginMapper.dtoToDomain(result)
    }

    override suspend fun saveLogin(login: Login) {
        val result = LoginMapper.domainToEntity(login)
        localDS.saveLogin(result)
    }

    override suspend fun getUser(): User {
        val result = localDS.getUser()
        return UserMapper.entityToDomain(result)
    }
}