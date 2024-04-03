package am.leon.solutionx.features.authentication.login.domain.usecases

import am.leon.solutionx.common.data.models.Resource
import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.domain.repository.ILoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginWithPhoneUC(private val repository: ILoginRepository) {

    operator fun invoke(

        scope: CoroutineScope, loginRequest: LoginRequest, needLoading: Boolean = true,
        onResult: (Resource<String>) -> Unit
    ) {
        scope.launch(Dispatchers.Main) {
            if (needLoading)
                onResult.invoke(Resource.loading())

            withContext(Dispatchers.IO) {
                val result = repository.loginWithPhone(loginRequest)
                repository.saveLogin(result)
                onResult.invoke(Resource.success(result.message))
            }

            withContext(Dispatchers.Main) {
                if (needLoading)
                    onResult.invoke(Resource.loading(false))
            }
        }
    }
}