package am.leon.solutionx.common.data.repository.local.keyValue

import am.leon.solutionx.common.domain.repository.local.keyValue.IStorageKeyEnum

enum class StorageKeyEnum(override val keyValue: String) : IStorageKeyEnum {
    ACCESS_TOKEN("accessToken"),
    USER("user"),
}