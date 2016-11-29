package com.eduvisor

class Subject {

    String subject1
    String subject2
    String subject3
    String subject4
    String subject5

    static belongsTo = [requirement:Requirement]

    static constraints = {
        subject1 blank: false
        subject2 blank: false
        subject3 blank: false
        subject4 blank: false
        subject5 blank: true
    }

    String toString() {"$subject1, $subject2, $subject3, $subject4"}
}
