package com.syouth.kmapper.testload

import com.syouth.kmapper.testload.domain.nonDataClassTest.DomainAddress
import com.syouth.kmapper.testload.domain.nonDataClassTest.DomainUser
import com.syouth.kmapper.testload.dto.listConvertionTest.ListDto
import com.syouth.kmapper.testload.dto.listConvertionTest.OtherListDto
import com.syouth.kmapper.testload.dto.moneyMapperTest.MoneyDto
import com.syouth.kmapper.testload.dto.recursiveDataClassTest.RecursiveDataClassDto
import com.syouth.kmapper.testload.dto.recursiveDataClassTest.RecursiveDataClassDtoSecond
import com.syouth.kmapper.testload.dto.recursiveDataClassTest.RecursiveDataClassDtoThird
import com.syouth.kmapper.testload.mappers.listConvertionTest.ListDtoMapperImpl
import com.syouth.kmapper.testload.mappers.listConvertionTest.ListMapperImpl
import com.syouth.kmapper.testload.mappers.moneyMapperTest.toMoney
import com.syouth.kmapper.testload.mappers.recursiveDataClassTest.RecursiveDataClassTestMapperImpl
import java.math.BigDecimal
import java.util.*


fun main() {

    val m = MoneyDto(22, "EUR")
    val money = m.toMoney()

    println(money)

    val rdd =
        RecursiveDataClassDto(
            RecursiveDataClassDtoSecond(
                RecursiveDataClassDtoThird(BigDecimal.ONE, "one", BigDecimal.ZERO), BigDecimal.TEN))
    val rMapper = RecursiveDataClassTestMapperImpl()
    println(rMapper.map(rdd))

    val listDto = ListDto(OtherListDto("Other"), listOf(OtherListDto("first"), OtherListDto("second")))
    val lMapper = ListDtoMapperImpl()
    println(lMapper.map(listDto))

    val listMapper = ListMapperImpl()
    println(listMapper.map(listDto, listOf(OtherListDto("third"), OtherListDto("fourth"))))

    val address = DomainAddress(UUID.randomUUID(), "10 Baker St", "London")
    val user = DomainUser(UUID.randomUUID(), "sherlock", "Sherlock", "Holmes", listOf(address))


}
