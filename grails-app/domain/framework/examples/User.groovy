package framework.examples

class User {

    String firstname
    String lastname
    String login
    String password

    static hasMany = [tasks: Task]

    static constraints = {
        firstname blank: false
        lastname blank: false
        login blank: false, unique: true
        password blank: false, size: 8..16
    }
}
