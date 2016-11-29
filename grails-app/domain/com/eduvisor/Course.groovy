package com.eduvisor

class Course {

    String name
    String description

    static belongsTo = [fieldOfStudy:FieldOfStudy]

    static constraints = {
        name blank: false, matches: /~[\d]+/
        description blank: false, size: 10..500
    }
}
