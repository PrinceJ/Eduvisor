package com.eduvisor

import javax.persistence.Id

class Usertable {

    @Id
    String username
    String password

    static constraints = {
        username blank: false
        password blank: false
    }
}
