package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Person2 implements Comparable<Person2> {
	private final int age;
	private final String lastName;
	private String firstName;

	public Person2(int age, String firstName, String lastName) {
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

	public void setFirstName(String n) {
		this.firstName = n;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Person2 p) {
		int result = Objects.compare(getFirstName(), p.getFirstName(), Comparator.naturalOrder());
		if (result != 0) {
			return result;
		}
		result = Objects.compare(getLastName(), p.getLastName(), Comparator.naturalOrder());
		if (result != 0) {
			return result;
		}
		return Objects.compare(age, p.getAge(), Comparator.naturalOrder());
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", " + age;
	}
}