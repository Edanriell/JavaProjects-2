package org.example;

import hiding.C;
import hiding.D;

import static org.example.StaticMembers.SomeClass.SOME_PROPERTY;
import static org.example.StaticMembers.SomeClass.someMethod;

public class Packages {
	public static void main(String... args) {
		C c = new C();
		D d = new D();

		StaticMembers.SomeClass obj = new StaticMembers.SomeClass();
		someMethod(42);
		System.out.println(SOME_PROPERTY);    //prints: abc
	}
}
