package com.syouth.kmapper.testload.dto.RecursiveTest

import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.OneToMany

/**
 * Initially created on 3/31/23.
 */

class RecDtoPartA(
    var id: Int,
    var name: String,
    @OneToMany(
        mappedBy = "partA",
        orphanRemoval = true
    )
    var relations: List<AtoBRelationDto> = mutableListOf()
)

class RecDtoPartB(
    var id: Int,
    var name: String,
    @OneToMany(
        mappedBy = "partB",
        orphanRemoval = true
    )
    var relations: List<AtoBRelationDto> = mutableListOf()
)

class AtoBRelationDto(
    var aId: Int,
    var bId: Int,
    var valid: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("aId")
    var partA: RecDtoPartA,
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bId")
    var partB: RecDtoPartB
)
