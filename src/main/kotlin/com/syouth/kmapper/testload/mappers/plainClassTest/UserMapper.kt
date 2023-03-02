package com.syouth.kmapper.testload.mappers.plainClassTest

import com.syouth.kmapper.processor_annotations.Mapper
import com.syouth.kmapper.testload.dto.plainClassTest.AdvancedUser
import com.syouth.kmapper.testload.dto.plainClassTest.SimpleUser

/**
 * Initially created on 3/2/23.
 */

@Mapper
internal interface Simple2AdvancedUserMapper {
    fun map(su: SimpleUser) : AdvancedUser
}
