package am.leon.solutionx.features.authentication.login.data.models.dto

import com.google.gson.annotations.SerializedName

internal data class LoginDto(
    @SerializedName("message") val message: String? = null,
    @SerializedName("token") val token: String? = null,
    @SerializedName("user") val user: UserDto? = null
)