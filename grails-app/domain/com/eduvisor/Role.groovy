package com.eduvisor

import javax.persistence.Id

class Role {

    @Id
    String roleName

    static hasMany = [usertable: Usertable]

    static constraints = {
        roleName blank: false
    }
}
