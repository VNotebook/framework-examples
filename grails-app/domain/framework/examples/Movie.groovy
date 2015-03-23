package framework.examples

import javax.annotation.Resource

@Resource()
class Movie {
    String title
    Genre genre
    String description
    Date launchDate
    String director

    static hasMany = [actors: Actor]

    static constraints = {
        title unique: true, blank: false
        genre blank: false
        description blank: false
        launchDate blank: false
        director blank: false
    }

    String toString() {
        return title
    }
}
