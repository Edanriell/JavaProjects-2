package org.example;

public class Address implements Cloneable {
	private final String city;
	private String street;

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	@Override
	public Address clone() throws CloneNotSupportedException {
		return (Address) super.clone();
	}
}
