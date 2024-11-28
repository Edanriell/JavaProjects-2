package org.example;

public class Person {
	private final int age;
	private final String firstName;
	private final String lastName;

	public Person(int age, String firstName, String lastName) {
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}