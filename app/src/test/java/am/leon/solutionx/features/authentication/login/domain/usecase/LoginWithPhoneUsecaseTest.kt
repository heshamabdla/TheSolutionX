package am.leon.solutionx.features.authentication.login.domain.usecase

import am.leon.solutionx.common.data.models.Resource
import am.leon.solutionx.common.data.models.exception.LeonException
import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.data.models.request.PhoneRequest
import am.leon.solutionx.features.authentication.login.data.repository.FakeRepository
import am.leon.solutionx.features.authentication.login.domain.models.Login
import am.leon.solutionx.features.authentication.login.domain.models.User
import am.leon.solutionx.features.authentication.login.domain.usecases.LoginWithPhoneUC
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import javax.security.auth.login.LoginException

class LoginWithPhoneUCTest {
    private lateinit var fakeRepository: FakeRepository
    private lateinit var loginWithPhoneUC: LoginWithPhoneUC
    private val coroutineTestRule = TestScope()

    @Before
    fun setup() {
        fakeRepository = FakeRepository()
        loginWithPhoneUC = LoginWithPhoneUC(fakeRepository)
    }

    @Test
    fun `invoke loginWithPhone method and returns expected result`() = runTest {
        val loginRequest = LoginRequest(PhoneRequest("002","01012345678"), "testPassword")
        val expectedLoginResponse = Login("testToken", "TestToken",User(1, "testEmail", "testPhone","testEmail"))
        fakeRepository.login = expectedLoginResponse

        val result = mutableListOf<Resource<Login>>()
        loginWithPhoneUC.invoke(coroutineTestRule,loginRequest){

//            Resource.Success
        }

        val lastResult = result.last()
        if (lastResult is Resource.Success) {
            assertEquals(expectedLoginResponse, lastResult.model)
        } else {
            Assert.fail()
        }
    }

    @Test
    fun `invoke returns failure when user enters incorrect input`() = runTest {

        val loginRequest = LoginRequest(PhoneRequest("002","01123456789"), "TestWrongPassword")
        fakeRepository.login = null


        val result = mutableListOf<Resource<Login>>()

        loginWithPhoneUC.invoke(coroutineTestRule,loginRequest){
//            Resource.Failure()
        }


        val lastResult = result.last()
        assertTrue(lastResult is Resource.Failure)
    }




}