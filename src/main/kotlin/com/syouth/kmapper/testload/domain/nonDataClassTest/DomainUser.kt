package com.syouth.kmapper.testload.domain.nonDataClassTest

import java.util.UUID

/**
 * Initially created on 1/25/23.
 */
data class DomainUser(
    val id: UUID,
    val login: String,
    val firstname: String,
    val lastname: String,
    val addresses: List<DomainAddress>)

data class DomainAddress(
    val id: UUID,
    val street: String,
    val town: String
)
