package com.syouth.kmapper.testload.dto.plainClassTest

/**
 * Initially created on 3/2/23.
 */
class SimpleUser (var firstname: String, var lastname: String)

class AdvancedUser (var firstname: String, var lastname: String, val hairColour: String? = null) {
    override fun toString(): String {
        return "AdvancedUser(firstname=$firstname, lastname=$lastname, hairColour=$hairColour)"
    }
}
