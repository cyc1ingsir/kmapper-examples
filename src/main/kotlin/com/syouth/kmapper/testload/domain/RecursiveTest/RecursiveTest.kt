package com.syouth.kmapper.testload.domain.RecursiveTest

/**
 * Initially created on 3/31/23.
 */

class RecDomainPartA(
    var id: Int,
    var name: String,
    var relations: List<AtoBRelationDomain>
) {
    override fun toString(): String {
        return "RecDomainPartB(id=$id, name=$name, relations=$relations )"
    }
}

class RecDomainPartB(
    var id: Int,
    var name: String,
    var relations: List<AtoBRelationDomain>) {

    override fun toString() : String {
        return "RecDomainPartB(id=$id, name=$name, relations=$relations )"
    }
}

class AtoBRelationDomain(
    var aId: Int,
    var bId: Int,
    var valid: String,
    var partA: RecDomainPartA,
    var partB: RecDomainPartB
){
    override fun toString(): String {
        return "A2BRelation(aId=$aId, bId=$bId, valid=$valid, partA=$partA, partB=$partB)"
    }
}
