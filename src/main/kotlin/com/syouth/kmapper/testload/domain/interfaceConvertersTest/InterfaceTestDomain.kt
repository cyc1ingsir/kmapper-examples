package com.syouth.kmapper.testload.domain.interfaceConvertersTest

import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class InterfaceTestDomain(
    // data type DTO -> To -> data type Domain
    // e.g. floatDTO To IntDomain
    //      bigDecimalDTO To StringDomain
    val floatToInt: Int,
    val doubleToFloat: Float?,
    val strToBigDecimal: BigDecimal,
    val bigDecimalToStr: String?
)
