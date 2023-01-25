package com.syouth.kmapper.testload.dto.nonDataClassTest

import java.util.UUID

/**
 * Initially created on 1/25/23.
 */
//data class UserEntity( <-- working
class UserEntity(
    var id: UUID,
    var login: String,
    var firstname: String,
    var lastname: String,
    var addresses: List<AddressEntity>)

//data class AddressEntity( <-- working
class AddressEntity(
    var id: UUID,
    var street: String,
    var town: String
)
