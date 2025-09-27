package com.syouth.kmapper.testload.domain.mapTest

import com.ionspin.kotlin.bignum.decimal.BigDecimal

internal data class MapTestDomain(
    val mapOne: Map<String, Int>,
    val mapTwo: Map<Int, Long>,
    val mapThree: HashMap<Long, BigDecimal>
)
