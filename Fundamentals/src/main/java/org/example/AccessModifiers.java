package org.example;

public class AccessModifiers {
	private final String topLevelPrivateProperty = "Top-level private value";
	public String prop4;
	protected String prop3;
	String prop1;
	private String prop2;

	public static void main(String... args) {
		var top = new AccessModifiers();
		top.topLevelPrivateMethod();
		// var inner = new InnerClass();  //error
		System.out.println(InnerStaticClass.PROP);
		var inner = new InnerStaticClass();
		System.out.println(inner.innerPrivateProperty);
		inner.innerPrivateMethod();
	}

	void method1() {
	}

	private void method2() {
	}

	protected void method3() {
	}

	public void method4() {
	}

	private void topLevelPrivateMethod() {
		var inner = new InnerClass();
		System.out.println(inner.innerPrivateProperty);
		inner.innerPrivateMethod();
	}

	interface I1 {
	}

	protected interface I2 {
	}

	private interface I3 {
	}

	public interface I4 {
	}

	private static class InnerStaticClass {
		private static final String PROP = "Inner private static";
		private final String innerPrivateProperty = "Inner private value";

		private void innerPrivateMethod() {
			var top = new AccessModifiers();
			System.out.println(top.topLevelPrivateProperty);
		}
	}

	class A1 {
	}

	protected class A2 {
	}

	private class A3 {
	}

	public class A4 {
	}

	private class InnerClass {
		// private static String PROP = "Inner static"; //error
		private final String innerPrivateProperty = "Inner private value";

		private void innerPrivateMethod() {
			System.out.println(topLevelPrivateProperty);
		}
	}
}