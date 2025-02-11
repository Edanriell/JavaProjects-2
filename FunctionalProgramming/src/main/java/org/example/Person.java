package org.example;

import java.util.Objects;

public class Person {
	private final int age;
	private final String firstName;
	private final String lastName;
	private String record;

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

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person person)) return false;
		return getAge() == person.getAge() &&
				getFirstName().equals(person.getFirstName()) &&
				getLastName().equals(person.getLastName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getAge(), getFirstName(), getLastName());
	}
}

