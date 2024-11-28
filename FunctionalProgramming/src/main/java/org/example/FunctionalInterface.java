package org.example;

public class FunctionalInterface {
	@java.lang.FunctionalInterface
	interface A {
		static void method3() {
		}

		void method1();

		default void method2() {
		}
	}

	@java.lang.FunctionalInterface
	interface B extends A {
		default void method4() {
		}
	}

	@java.lang.FunctionalInterface
	interface C extends B {
		void method1();
	}

	// @FunctionalInterface  //compilation error
	interface D extends C {
		void method5();
	}
}
