package framework.examples

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class GenreController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Transactional(readOnly = true)
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Genre.list(params), model: [genreInstanceCount: Genre.count()]
    }

    @Transactional(readOnly = true)
    def show(Genre genreInstance) {
        respond genreInstance
    }

    def create() {
        respond new Genre(params)
    }

    @Transactional(readOnly = false)
    def save(Genre genreInstance) {
        if (genreInstance == null) {
            notFound()
            return
        }

        if (genreInstance.hasErrors()) {
            respond genreInstance.errors, view: 'create.html'
            return
        }

        genreInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'genre.label', default: 'Genre'), genreInstance.id])
                redirect genreInstance
            }
            '*' { respond genreInstance, [status: CREATED] }
        }
    }

    def edit(Genre genreInstance) {
        respond genreInstance
    }

    @Transactional(readOnly = false)
    def update(Genre genreInstance) {
        if (genreInstance == null) {
            notFound()
            return
        }

        if (genreInstance.hasErrors()) {
            respond genreInstance.errors, view: 'edit'
            return
        }

        genreInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Genre.label', default: 'Genre'), genreInstance.id])
                redirect genreInstance
            }
            '*' { respond genreInstance, [status: OK] }
        }
    }

    @Transactional(readOnly = false)
    def delete(Genre genreInstance) {

        if (genreInstance == null) {
            notFound()
            return
        }

        genreInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Genre.label', default: 'Genre'), genreInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'genre.label', default: 'Genre'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
