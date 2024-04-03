package am.leon.solutionx.features.authentication.login.data.models.dto

import com.google.gson.annotations.SerializedName

internal data class UserDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("username") val userName: String? = null,
    @SerializedName("firstname") val firstName: String? = null,
    @SerializedName("middlename") val middleName: String? = null,
    @SerializedName("lastname") val lastName: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phone") val phone: PhoneDto? = null,
    @SerializedName("image") val imageUrl: String? = null,
    @SerializedName("birthdate") val birthDate: String? = null,
    @SerializedName("email_verified") val isEmailVerified: Boolean? = null,
    @SerializedName("phone_verified") val isPhoneVerified: Boolean? = null,
    @SerializedName("blocked") val blocked: Int? = null,
    @SerializedName("country") val country: CountryDto? = null
)