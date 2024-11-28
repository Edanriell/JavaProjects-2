package org.example;

import java.io.Serializable;
 
public class Person1 implements Serializable {
	private final int age;
	private final String name;

	public Person1(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
