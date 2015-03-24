package todoapp

class Activity {
	String description, title
	Date creationDate
	boolean completed
	static belongsTo = [person: Person]
	static constraints = {
		title()
		description()
		creationDate()
		completed()
	}

	@Override
	String toString () {
		title
	}
}
