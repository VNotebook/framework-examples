package framework.examples

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
