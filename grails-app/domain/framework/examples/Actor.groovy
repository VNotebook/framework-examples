package framework.examples

import javax.annotation.Resource

@Resource()
class Actor {
    String firstname
    String lastname
    Integer age

    static hasMany = [movies: Movie]
    static belongsTo = [Movie]

    static constraints = {
        firstname blank: false
        lastname blank: false
        age range: 1..125, nullable: true
    }

    String toString() {
        return lastname + ", " + firstname
    }
}
