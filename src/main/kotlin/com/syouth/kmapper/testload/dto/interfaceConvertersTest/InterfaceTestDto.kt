package com.syouth.kmapper.testload.dto.interfaceConvertersTest

import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class InterfaceTestDto(
    // data type DTO -> To -> data type Domain
    // e.g. floatDTO To IntDomain
    //      bigDecimalDTO To StringDomain
    val floatToInt: Float,
    val doubleToFloat: Double,
    val strToBigDecimal: String,
    val bigDecimalToString: BigDecimal?
)
