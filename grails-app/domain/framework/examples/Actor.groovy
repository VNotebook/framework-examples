package framework.examples

import grails.rest.*

@Resource(uri="/actores")
class Actor {
    String firstname
    String lastname
    Integer age

    static hasMany = [movies: Movie]
    static belongsTo = [Movie]

    static constraints = {
        firstname blank: false
        lastname blank: false
        age nullable: true
    }

    String toString() {
        return lastname + ", " + firstname
    }
}
