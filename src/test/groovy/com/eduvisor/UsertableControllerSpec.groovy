package com.eduvisor

import grails.test.mixin.*
import spock.lang.*

@TestFor(UsertableController)
@Mock(Usertable)
class UsertableControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.usertableList
            model.usertableCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.usertable!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def usertable = new Usertable()
            usertable.validate()
            controller.save(usertable)

        then:"The create view is rendered again with the correct model"
            model.usertable!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            usertable = new Usertable(params)

            controller.save(usertable)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/usertable/show/1'
            controller.flash.message != null
            Usertable.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def usertable = new Usertable(params)
            controller.show(usertable)

        then:"A model is populated containing the domain instance"
            model.usertable == usertable
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def usertable = new Usertable(params)
            controller.edit(usertable)

        then:"A model is populated containing the domain instance"
            model.usertable == usertable
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/usertable/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def usertable = new Usertable()
            usertable.validate()
            controller.update(usertable)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.usertable == usertable

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            usertable = new Usertable(params).save(flush: true)
            controller.update(usertable)

        then:"A redirect is issued to the show action"
            usertable != null
            response.redirectedUrl == "/usertable/show/$usertable.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/usertable/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def usertable = new Usertable(params).save(flush: true)

        then:"It exists"
            Usertable.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(usertable)

        then:"The instance is deleted"
            Usertable.count() == 0
            response.redirectedUrl == '/usertable/index'
            flash.message != null
    }
}
