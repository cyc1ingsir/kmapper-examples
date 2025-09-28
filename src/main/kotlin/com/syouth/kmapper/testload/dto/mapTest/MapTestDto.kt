package com.syouth.kmapper.testload.dto.mapTest

import com.ionspin.kotlin.bignum.decimal.BigDecimal

internal data class MapTestDto(
    val mapOne: Map<String, Int>,
    val mapTwo: Map<Long, BigDecimal>,
    val mapThree: HashMap<Int, String>
)
