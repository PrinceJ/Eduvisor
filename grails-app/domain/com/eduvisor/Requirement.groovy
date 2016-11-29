package com.eduvisor

class Requirement {

    String details
    Integer jambCutOfff
    Integer utmeScore

    static hasOne = [subject:Subject]
    static belongsTo = [course:Course]

    static constraints = {
        details blank: false
        jambCutOfff blank: false, min: 140, max: 300
        utmeScore blank: false
    }
}
