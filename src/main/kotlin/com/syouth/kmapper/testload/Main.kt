package com.syouth.kmapper.testload

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.syouth.kmapper.testload.domain.nonDataClassTest.DomainAddress
import com.syouth.kmapper.testload.domain.nonDataClassTest.DomainUser
import com.syouth.kmapper.testload.dto.RecursiveTest.AtoBRelationDto
import com.syouth.kmapper.testload.dto.RecursiveTest.RecDtoPartA
import com.syouth.kmapper.testload.dto.RecursiveTest.RecDtoPartB
import com.syouth.kmapper.testload.dto.interfaceConvertersTest.InterfaceTestDto
import com.syouth.kmapper.testload.dto.listConvertionTest.ListDto
import com.syouth.kmapper.testload.dto.listConvertionTest.OtherListDto
import com.syouth.kmapper.testload.dto.moneyMapperTest.MoneyDto
import com.syouth.kmapper.testload.dto.plainClassTest.SimpleUser
import com.syouth.kmapper.testload.dto.recursiveDataClassTest.RecursiveDataClassDto
import com.syouth.kmapper.testload.dto.recursiveDataClassTest.RecursiveDataClassDtoSecond
import com.syouth.kmapper.testload.dto.recursiveDataClassTest.RecursiveDataClassDtoThird
import com.syouth.kmapper.testload.mappers.interfaceConverterTest.InterfaceConverterMapperImpl
import com.syouth.kmapper.testload.mappers.listConvertionTest.ListDtoMapperImpl
import com.syouth.kmapper.testload.mappers.listConvertionTest.ListMapperImpl
import com.syouth.kmapper.testload.mappers.moneyMapperTest.toMoney
import com.syouth.kmapper.testload.mappers.nonDataClassTest.DomainUser2EntityMapperImpl
import com.syouth.kmapper.testload.mappers.nonDataClassTest.UserEntity2DomainMapperImpl
import com.syouth.kmapper.testload.mappers.plainClassTest.Simple2AdvancedUserMapperImpl
import com.syouth.kmapper.testload.mappers.recursiveDataClassTest.RecursiveDataClassTestMapperImpl
import com.syouth.kmapper.testload.mappers.recursiveTest.PartADto2DomainMapperImpl
import com.syouth.kmapper.testload.mappers.recursiveTest.PartBDto2DomainMapperImpl
import com.syouth.kmapper.testload.mappers.recursiveTest.RelationDto2DomainMapperImpl
import java.util.UUID

fun main() {

    // Parts
    val dtoPartB = findPartB()

    val partBMapper = PartBDto2DomainMapperImpl()
    val partAMapper = PartADto2DomainMapperImpl()

    val relationMapper = RelationDto2DomainMapperImpl()
    val domainRelations = dtoPartB.relations.map { relation ->
        relationMapper.map(
            relation,
            partAMapper.map(relation.partA, mutableListOf()),
            partBMapper.map(relation.partB, mutableListOf())
        )
    }
    val domainPartB = partBMapper.map(dtoPartB, domainRelations.toMutableList())

    println(domainPartB)

    // Money
    val m = MoneyDto(22, "EUR")
    val money = m.toMoney()

    println(money)

    // InterfaceConverter
    val interfaceTestDto = InterfaceTestDto(1.0f, 2.0, "3.0", BigDecimal.TEN)
    val interfaceConverterMapper = InterfaceConverterMapperImpl()
    val testDomainObject = interfaceConverterMapper.map(interfaceTestDto)
    println (testDomainObject)
    // Recursive
    val rdd =
        RecursiveDataClassDto(
            RecursiveDataClassDtoSecond(
                RecursiveDataClassDtoThird(BigDecimal.ONE, "one", BigDecimal.ZERO), BigDecimal.TEN))
    val rMapper = RecursiveDataClassTestMapperImpl()
    println(rMapper.map(rdd))

    // Lists
    val listDto = ListDto(OtherListDto("Other"), listOf(OtherListDto("first"), OtherListDto("second")))
    val lMapper = ListDtoMapperImpl()
    println(lMapper.map(listDto))

    val listMapper = ListMapperImpl()
    println(listMapper.map(listDto, listOf(OtherListDto("third"), OtherListDto("fourth"))))

    // User entity including address
    val addressBaker = DomainAddress(UUID.randomUUID(), "10 Baker St", "London")
    val addressScot = DomainAddress(UUID.randomUUID(), "10 Wood St", "Edinburgh")
    val user = DomainUser(UUID.randomUUID(), "sherlock", "Sherlock", "Holmes",
            listOf(addressBaker, addressScot))

    val domainUser2EntityMapper = DomainUser2EntityMapperImpl()
    val userEntity = domainUser2EntityMapper.map(user)
    println(userEntity)

    val entity2DomainMapper = UserEntity2DomainMapperImpl()
    println(entity2DomainMapper.map(userEntity))

    val simpleUser = SimpleUser("Sherlock", "Holmes")
    val simple2AdvancedUserMapper = Simple2AdvancedUserMapperImpl()
    val advancedUser = simple2AdvancedUserMapper.map(simpleUser)
    println(advancedUser)
}

private fun findPartB(): RecDtoPartB {
    val aOneDto = RecDtoPartA(1, "A one")
    val aTwoDto = RecDtoPartA(2, "A two")
    val aThreeDto = RecDtoPartA(3, "A three")
    val partBRoomDto = RecDtoPartB(1, "Room")
    val relOneDto = AtoBRelationDto(1, 1, "morning", aOneDto, partBRoomDto)
    val relTwoDto = AtoBRelationDto(2, 1, "lunch", aTwoDto, partBRoomDto)
    val relThreeDto = AtoBRelationDto(2, 1, "evening", aThreeDto, partBRoomDto)

    partBRoomDto.relations = mutableListOf(relOneDto, relTwoDto, relThreeDto)

    return partBRoomDto
}
