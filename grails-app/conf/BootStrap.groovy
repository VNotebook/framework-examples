import framework.examples.Actor
import framework.examples.Genre
import framework.examples.Movie

class BootStrap {

    def init = { servletContext ->
        def terrorGenre = new Genre(name: "terror").save(failOnError: true)
        def loveGenre = new Genre(name: "love").save(failOnError: true)
        def alberActor = new Actor(firstname: "Alber", lastname: "Jas", age: 25).save(failOnError: true)
        def alamActor = new Actor(firstname: "Alam", lastname: "Brito", age: 30).save(failOnError: true)

        def tamalMovie = new Movie(title: "Perdidos en un tamal", description: "asdfjasdflasdf", genre: terrorGenre, launchDate: new Date(), director: "Jefferson Hernández")
        tamalMovie.addToActors(alberActor)
        tamalMovie.save(failOnError: true)
    }
    def destroy = {
    }
}
