package am.leon.solutionx.features.authentication.login.data.repository

import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.domain.models.Login
import am.leon.solutionx.features.authentication.login.domain.models.User
import am.leon.solutionx.features.authentication.login.domain.repository.ILoginRepository
import org.junit.Assert.*

class FakeRepository: ILoginRepository{
    var login: Login? = null

    override suspend fun loginWithEmail(email: String, password: String): Login {
        TODO("Not yet implemented")
    }

    override suspend fun loginWithPhone(loginRequest: LoginRequest): Login {
        return login?: throw Exception("Test Exception")
    }

    override suspend fun saveLogin(login: Login) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): User {
        return User(1,"firstNameTest","fullNameTest","emailTest")
    }

}