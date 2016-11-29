package com.eduvisor

class Institution {

    String name
    String address
    String email
    String phone
    String region
    String website

    static constraints = {
        name blank: false
        address blank: false
        email blank: false, email: true
        phone blank: false, matches: /[\d]+/
        region blank: false
        website blank: false
    }
}
