package am.leon.solutionx.features.authentication.login.data.repository.remote


import am.leon.solutionx.features.authentication.login.data.models.dto.LoginDto
import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.data.models.request.PhoneRequest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RemoteDataSourceTest {

    private lateinit var provider: FakeRestApiNetworkProvider
    private lateinit var remoteDataSource: LoginRemoteDS

    @Before
    fun setUp() {
        provider = FakeRestApiNetworkProvider()
        remoteDataSource = LoginRemoteDS(provider)
    }

    @Test
    fun loginWithPhoneReturnsExpectedResult() = runTest {
        val loginRequest = LoginRequest(PhoneRequest("002","100100100"), "passwordTest")
        val expectedResponse = LoginDto("tokenTest", null)

        provider.postFakeResponse = expectedResponse

        val result = remoteDataSource.loginWithPhone(loginRequest)

        assertEquals(expectedResponse, result)
    }
}