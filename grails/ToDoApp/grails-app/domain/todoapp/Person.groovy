package todoapp

class Person {
	String name
	static hasMany = [activities : Activity]

	static constraints = {
		name()
	}

	@Override
	String toString () {
		name
	}
}
