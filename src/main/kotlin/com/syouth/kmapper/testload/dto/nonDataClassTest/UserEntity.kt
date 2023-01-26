package com.syouth.kmapper.testload.dto.nonDataClassTest

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID

/**
 * Initially created on 1/25/23.
 */
//data class UserEntity( <-- working
@Entity
class UserEntity(
    @Id var id: UUID,
    var login: String,
    var firstname: String,
    var lastname: String,
    @OneToMany var addresses: MutableList<AddressEntity> = mutableListOf()) {

    override fun toString() : String {
        return "UserEntity(id=$id, login=$login, firstname=$firstname, lastname=$lastname, addresses="+ addresses.toString() + ")"
    }
}

//data class AddressEntity( <-- working
@Entity
class AddressEntity(
    @Id var id: UUID,
    var street: String,
    var town: String) {
    override fun toString(): String {
        return "AddressEntity(id=$id, street=$street, town=$town)"
    }
}
