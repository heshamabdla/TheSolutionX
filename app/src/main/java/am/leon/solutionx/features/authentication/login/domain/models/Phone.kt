package am.leon.solutionx.features.authentication.login.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phone(
    val id: Int,
    val countryCode: String,
    val number: String,
) : Parcelable