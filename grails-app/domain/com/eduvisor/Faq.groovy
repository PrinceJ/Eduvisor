package com.eduvisor

class Faq {

    String question
    String answer

    static constraints = {

        question blank: false
        answer blank: false
    }
}
