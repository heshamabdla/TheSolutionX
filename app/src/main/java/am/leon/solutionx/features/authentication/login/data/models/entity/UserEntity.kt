package am.leon.solutionx.features.authentication.login.data.models.entity

internal data class UserEntity(
    val id: Int,
    val userName: String,
    val fullName: String,
    val email: String
)