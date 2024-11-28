package org.example;

public class Person3 implements Cloneable {
	private final int age;
	private final Address address;
	private final String firstName;
	private final String lastName;

	public Person3(int age, String firstName, String lastName, Address address) {
		this.age = age;
		this.address = address;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() {
		return address;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public Person3 clone() throws CloneNotSupportedException {
		return (Person3) super.clone();
	}
}
