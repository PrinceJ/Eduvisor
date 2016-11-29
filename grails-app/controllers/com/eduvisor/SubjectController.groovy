package com.eduvisor

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SubjectController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Subject.list(params), model:[subjectCount: Subject.count()]
    }

    def show(Subject subject) {
        respond subject
    }

    def create() {
        respond new Subject(params)
    }

    @Transactional
    def save(Subject subject) {
        if (subject == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (subject.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond subject.errors, view:'create'
            return
        }

        subject.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'subject.label', default: 'Subject'), subject.id])
                redirect subject
            }
            '*' { respond subject, [status: CREATED] }
        }
    }

    def edit(Subject subject) {
        respond subject
    }

    @Transactional
    def update(Subject subject) {
        if (subject == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (subject.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond subject.errors, view:'edit'
            return
        }

        subject.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'subject.label', default: 'Subject'), subject.id])
                redirect subject
            }
            '*'{ respond subject, [status: OK] }
        }
    }

    @Transactional
    def delete(Subject subject) {

        if (subject == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        subject.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'subject.label', default: 'Subject'), subject.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
