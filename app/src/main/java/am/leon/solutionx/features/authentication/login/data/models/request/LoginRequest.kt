package am.leon.solutionx.features.authentication.login.data.models.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("phone")
    val phone: PhoneRequest,
    @SerializedName("password")
    val password: String
)