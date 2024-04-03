package am.leon.solutionx.features.authentication.login.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val userName: String,
    val fullName: String,
    val email: String
) : Parcelable