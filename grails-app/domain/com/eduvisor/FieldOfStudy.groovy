package com.eduvisor

class FieldOfStudy {

    String name
    String description

    static hasMany = [courses:Course]
    static belongsTo = [institution:Institution]

    static constraints = {
        name blank: false
        description blank: false
    }
}
