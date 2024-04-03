package am.leon.solutionx.presentation.activities.main

import am.leon.solutionx.common.data.models.Resource
import am.leon.solutionx.common.presentation.SolutionXViewModel
import am.leon.solutionx.common.presentation.ViewAction
import am.leon.solutionx.features.authentication.login.data.models.request.LoginRequest
import am.leon.solutionx.features.authentication.login.data.models.request.PhoneRequest
import am.leon.solutionx.features.authentication.login.domain.usecases.LoginWithPhoneUC
import am.leon.solutionx.presentation.activities.main.MainViewContract.MainAction
import am.leon.solutionx.presentation.activities.main.MainViewContract.MainEvent
import am.leon.solutionx.presentation.activities.main.MainViewContract.MainState
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val loginWithPhoneUC: LoginWithPhoneUC
) : SolutionXViewModel<MainAction, MainEvent, MainState>(MainState.initial()) {



    private fun loginWithPhone(phone: String, password: String) {
        val request = LoginRequest(PhoneRequest("0020", phone), password)

        loginWithPhoneUC.invoke(viewModelScope, request) {
            when (it) {
                is Resource.Failure -> setState(oldViewState.copy(exception = it.exception))
                is Resource.Progress -> setState(oldViewState.copy(isLoading = it.loading))
                is Resource.Success -> sendEvent(MainEvent.LoginIsSuccessfully(it.model))
            }
        }
    }

    override fun onActionTrigger(action: ViewAction?) {
        setState(oldViewState.copy(action = action))
        when (action) {
            is MainAction.LoginWithEmail -> loginWithPhone(action.email, action.password)
        }
    }

    override fun clearState() {
        setState(MainState.initial())
    }
}