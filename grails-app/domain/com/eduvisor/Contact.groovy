package com.eduvisor

class Contact {

    String email
    String message

    static constraints = {
        email blank: false, email: true
        message blank: false, minSize: 50, maxSize: 1000
    }
}
