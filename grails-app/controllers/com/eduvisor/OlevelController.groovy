package com.eduvisor

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OlevelController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Olevel.list(params), model:[olevelCount: Olevel.count()]
    }

    def show(Olevel olevel) {
        respond olevel
    }

    def create() {
        respond new Olevel(params)
    }

    @Transactional
    def save(Olevel olevel) {
        if (olevel == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (olevel.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond olevel.errors, view:'create'
            return
        }

        olevel.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'olevel.label', default: 'Olevel'), olevel.id])
                redirect olevel
            }
            '*' { respond olevel, [status: CREATED] }
        }
    }

    def edit(Olevel olevel) {
        respond olevel
    }

    @Transactional
    def update(Olevel olevel) {
        if (olevel == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (olevel.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond olevel.errors, view:'edit'
            return
        }

        olevel.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'olevel.label', default: 'Olevel'), olevel.id])
                redirect olevel
            }
            '*'{ respond olevel, [status: OK] }
        }
    }

    @Transactional
    def delete(Olevel olevel) {

        if (olevel == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        olevel.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'olevel.label', default: 'Olevel'), olevel.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'olevel.label', default: 'Olevel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
