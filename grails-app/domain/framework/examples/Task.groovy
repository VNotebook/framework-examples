package framework.examples

class Task {
    Date date
    Boolean completed = false
    String title
    String description
    Date createdDate = new Date()

    static belongsTo = [User]

    static hasMany = [tags: Tag]

    static constraints = {
        date blank: false
        description maxSize: 1000
        title blank: false
        description nullable: true
    }
}
