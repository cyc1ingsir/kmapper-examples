package com.syouth.kmapper.testload.dto.interfaceConvertersTest

import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class InterfaceTestDto(
    val floatToInt: Float,
    val doubleToFloat: Double,
    val strToBigDecimal: String,
    val bigDecimalToString: BigDecimal?
)
