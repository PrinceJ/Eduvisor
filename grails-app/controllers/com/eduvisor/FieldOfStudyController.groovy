package com.eduvisor

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FieldOfStudyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond FieldOfStudy.list(params), model:[fieldOfStudyCount: FieldOfStudy.count()]
    }

    def show(FieldOfStudy fieldOfStudy) {
        respond fieldOfStudy
    }

    def create() {
        respond new FieldOfStudy(params)
    }

    @Transactional
    def save(FieldOfStudy fieldOfStudy) {
        if (fieldOfStudy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (fieldOfStudy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond fieldOfStudy.errors, view:'create'
            return
        }

        fieldOfStudy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fieldOfStudy.label', default: 'FieldOfStudy'), fieldOfStudy.id])
                redirect fieldOfStudy
            }
            '*' { respond fieldOfStudy, [status: CREATED] }
        }
    }

    def edit(FieldOfStudy fieldOfStudy) {
        respond fieldOfStudy
    }

    @Transactional
    def update(FieldOfStudy fieldOfStudy) {
        if (fieldOfStudy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (fieldOfStudy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond fieldOfStudy.errors, view:'edit'
            return
        }

        fieldOfStudy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fieldOfStudy.label', default: 'FieldOfStudy'), fieldOfStudy.id])
                redirect fieldOfStudy
            }
            '*'{ respond fieldOfStudy, [status: OK] }
        }
    }

    @Transactional
    def delete(FieldOfStudy fieldOfStudy) {

        if (fieldOfStudy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        fieldOfStudy.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fieldOfStudy.label', default: 'FieldOfStudy'), fieldOfStudy.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fieldOfStudy.label', default: 'FieldOfStudy'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
