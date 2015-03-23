package framework.examples

import javax.annotation.Resource

@Resource()
class Genre {

    String name

    static hasMany = [movies: Movie]
    static belongsTo = [Movie]

    static constraints = {
        name unique: true, blank: false
    }

    String toString() {
        return name
    }
}
