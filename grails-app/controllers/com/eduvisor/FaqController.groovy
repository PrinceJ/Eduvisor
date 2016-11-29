package com.eduvisor

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FaqController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Faq.list(params), model:[faqCount: Faq.count()]
    }

    def show(Faq faq) {
        respond faq
    }

    def create() {
        respond new Faq(params)
    }

    @Transactional
    def save(Faq faq) {
        if (faq == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (faq.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond faq.errors, view:'create'
            return
        }

        faq.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'faq.label', default: 'Faq'), faq.id])
                redirect faq
            }
            '*' { respond faq, [status: CREATED] }
        }
    }

    def edit(Faq faq) {
        respond faq
    }

    @Transactional
    def update(Faq faq) {
        if (faq == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (faq.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond faq.errors, view:'edit'
            return
        }

        faq.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'faq.label', default: 'Faq'), faq.id])
                redirect faq
            }
            '*'{ respond faq, [status: OK] }
        }
    }

    @Transactional
    def delete(Faq faq) {

        if (faq == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        faq.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'faq.label', default: 'Faq'), faq.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'faq.label', default: 'Faq'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
