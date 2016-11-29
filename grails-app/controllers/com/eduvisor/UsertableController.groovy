package com.eduvisor

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UsertableController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Usertable.list(params), model:[usertableCount: Usertable.count()]
    }

    def show(Usertable usertable) {
        respond usertable
    }

    def create() {
        respond new Usertable(params)
    }

    @Transactional
    def save(Usertable usertable) {
        if (usertable == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (usertable.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond usertable.errors, view:'create'
            return
        }

        usertable.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usertable.label', default: 'Usertable'), usertable.id])
                redirect usertable
            }
            '*' { respond usertable, [status: CREATED] }
        }
    }

    def edit(Usertable usertable) {
        respond usertable
    }

    @Transactional
    def update(Usertable usertable) {
        if (usertable == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (usertable.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond usertable.errors, view:'edit'
            return
        }

        usertable.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usertable.label', default: 'Usertable'), usertable.id])
                redirect usertable
            }
            '*'{ respond usertable, [status: OK] }
        }
    }

    @Transactional
    def delete(Usertable usertable) {

        if (usertable == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        usertable.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usertable.label', default: 'Usertable'), usertable.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usertable.label', default: 'Usertable'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
