package framework.examples

class Tag {

    String name

    static belongsTo = [Task]

    static hasMany = [tasks: Task]

    static constraints = {
        name blank: false
    }
}
