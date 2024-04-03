package am.leon.solutionx.features.authentication.login.data.mappers

import am.leon.solutionx.common.data.mapper.Mapper
import am.leon.solutionx.features.authentication.login.data.models.dto.PhoneDto
import am.leon.solutionx.features.authentication.login.domain.models.Phone

internal object PhoneMapper : Mapper<PhoneDto, Phone, Unit>() {
    override fun dtoToDomain(model: PhoneDto): Phone {
        return Phone(
            id = model.id ?: -1,
            number = model.number.orEmpty(),
            countryCode = model.countryCode.orEmpty()
        )
    }
}