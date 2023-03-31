package com.syouth.kmapper.testload.mappers.recursiveTest

import com.syouth.kmapper.processor_annotations.Bind
import com.syouth.kmapper.processor_annotations.Mapper
import com.syouth.kmapper.testload.domain.RecursiveTest.AtoBRelationDomain
import com.syouth.kmapper.testload.domain.RecursiveTest.RecDomainPartA
import com.syouth.kmapper.testload.domain.RecursiveTest.RecDomainPartB
import com.syouth.kmapper.testload.dto.RecursiveTest.AtoBRelationDto
import com.syouth.kmapper.testload.dto.RecursiveTest.RecDtoPartA
import com.syouth.kmapper.testload.dto.RecursiveTest.RecDtoPartB

/**
 * Initially created on 3/31/23.
 */
/*
Defining the Mapper like below leads to a infinite loop
        at com.syouth.kmapper.processor.convertors.PojoClassTypeConverter.buildConversionStatement(PojoClassTypeConverter.kt:43)
        at com.syouth.kmapper.processor.convertors.CollectionTypeConverter.buildCodeBlockForDataClasses(CollectionTypeConverter.kt:66)
        at com.syouth.kmapper.processor.convertors.CollectionTypeConverter.buildConversionStatement(CollectionTypeConverter.kt:35)
        at com.syouth.kmapper.processor.convertors.PojoClassTypeConverter.buildCodeBlockForDifferentTypes(PojoClassTypeConverter.kt:70)
        at com.syouth.kmapper.processor.convertors.PojoClassTypeConverter.buildConversionStatement(PojoClassTypeConverter.kt:43)
        at com.syouth.kmapper.processor.convertors.PojoClassTypeConverter.buildCodeBlockForDifferentTypes(PojoClassTypeConverter.kt:70)
        at com.syouth.kmapper.processor.convertors.PojoClassTypeConverter.buildConversionStatement(PojoClassTypeConverter.kt:43)
        at com.syouth.kmapper.processor.convertors.CollectionTypeConverter.buildCodeBlockForDataClasses(CollectionTypeConverter.kt:66)


@Mapper
interface RecursiveTestMapper {

    fun map(dto: RecDtoPartB) : RecDomainPartB

}
*/

/*@Mapper
interface PartBDto2DomainMapper {
    fun map(dto: RecDtoPartB, @Bind relations: MutableList<AtoBRelationDomain>) : RecDomainPartB

    fun map(domain: RecDomainPartB, @Bind relations: MutableList<AtoBRelationDto>) : RecDtoPartB
}*/

interface RelationMapperHelper {

    fun mapRelationMember(dto: RecDtoPartB): RecDomainPartB = mapWithList(dto, mutableListOf())
    fun mapRelationMember(dto: RecDtoPartA): RecDomainPartA = mapWithList(dto, mutableListOf())
    fun mapWithList(dto: RecDtoPartA, @Bind relations: MutableList<AtoBRelationDomain>) : RecDomainPartA
    fun mapWithList(dto: RecDtoPartB, @Bind relations: MutableList<AtoBRelationDomain>) : RecDomainPartB

}

@Mapper
interface PartBDto2DomainMapper  {
    fun map(dto: RecDtoPartB) : RecDomainPartB

}

@Mapper
interface PartADto2DomainMapper {
    fun map(dto: RecDtoPartA) : RecDomainPartA
}

@Mapper
interface RelationDto2DomainMapper: RelationMapperHelper {
    fun map(dto: AtoBRelationDto) : AtoBRelationDomain
}
