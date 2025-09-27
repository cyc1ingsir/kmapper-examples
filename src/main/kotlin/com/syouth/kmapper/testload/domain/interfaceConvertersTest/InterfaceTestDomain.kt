package com.syouth.kmapper.testload.domain.interfaceConvertersTest

import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class InterfaceTestDomain(
    val floatToInt: Int,
    val doubleToFloat: Float?,
    val strToBigDecimal: BigDecimal,
    val bigDecimalToStr: String?
)
