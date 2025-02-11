package org.example;

public class Person4 implements Cloneable {
	private final int age;
	private final String firstName;
	private final String lastName;
	private Address address;

	public Person4(int age, String firstName, String lastName, Address address) {
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
	public Person4 clone() throws CloneNotSupportedException {
		Person4 cl = (Person4) super.clone();
		cl.address = this.address.clone();
		return cl;
	}
}
