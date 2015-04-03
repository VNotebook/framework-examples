package framework.examples

import grails.rest.*

@Resource(uri="/peliculas")
class Movie {

    String title
    String description
    String director
    Date launchDate

    static hasMany = [actors: Actor, genres: Genre]

    static constraints = {
        title blank: false
        launchDate blank: false
        description blank: false
        director blank: false
    }
}
