package com.syouth.kmapper.testload.mappers.nonDataClassTest

import com.syouth.kmapper.processor_annotations.Mapper
import com.syouth.kmapper.testload.domain.nonDataClassTest.DomainAddress
import com.syouth.kmapper.testload.domain.nonDataClassTest.DomainUser
import com.syouth.kmapper.testload.dto.nonDataClassTest.AddressEntity
import com.syouth.kmapper.testload.dto.nonDataClassTest.UserEntity

/**
 * Initially created on 1/25/23.
 */
@Mapper
internal fun interface DomainUser2EntityMapper {
    fun map(du: DomainUser) : UserEntity
}
@Mapper
internal fun interface DomainAddress2EntityMapper {
    fun map(da: DomainAddress) : AddressEntity
}

@Mapper
internal fun interface UserEntity2DomainMapper {
    fun map(ue: UserEntity ) : DomainUser
}

@Mapper
internal fun interface AddressEntity {
    fun map(ae: AddressEntity) : DomainAddress
}
