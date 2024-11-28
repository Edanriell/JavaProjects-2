package org.example;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ColdObservable {
	public static void main(String... args) {
		Observable<Long> cold = Observable.interval(10, TimeUnit.MILLISECONDS);
		cold.subscribe(i -> System.out.println("First: " + i));
		pauseMs(25);
		cold.subscribe(i -> System.out.println("Second: " + i));
		pauseMs(55);
	}

	private static void pauseMs(long ms) {
		try {
			TimeUnit.MILLISECONDS.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
