package org.example;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class HotObservable {
	public static void main(String... args) {
		hot1();
		hot2();
		hot3();
		hot4();
	}

	private static void hot1() {
		System.out.println("\nhot1():");
		ConnectableObservable<Long> hot = Observable.interval(10, TimeUnit.MILLISECONDS).publish();
		hot.connect();

		hot.subscribe(i -> System.out.println("First: " + i));
		pauseMs(25);

		hot.subscribe(i -> System.out.println("Second: " + i));
		pauseMs(55);
	}

	private static void hot2() {
		System.out.println("\nhot2():");
		PublishProcessor<Integer> hot = PublishProcessor.create();

		hot.observeOn(Schedulers.io(), true)
				.subscribe(System.out::println, Throwable::printStackTrace);

		for (int i = 0; i < 1_000_000; i++) {
			hot.onNext(i);
		}
	}

	private static void hot3() {
		System.out.println("\nhot3():");
		PublishProcessor<Integer> hot = PublishProcessor.create();

		hot.observeOn(Schedulers.io(), true)
				.delay(10, TimeUnit.MILLISECONDS)
				.subscribe(System.out::println, Throwable::printStackTrace);

		for (int i = 0; i < 1_000_000; i++) {
			hot.onNext(i);
		}
	}

	private static void hot4() {
		System.out.println("\nhot4():");
		PublishProcessor<Integer> hot = PublishProcessor.create();

		hot.onBackpressureDrop(v -> System.out.println("Dropped: " + v))
				.observeOn(Schedulers.io(), true)
				// .delay(10, TimeUnit.MILLISECONDS)
				.subscribe(System.out::println, Throwable::printStackTrace);

		for (int i = 0; i < 1_000_000; i++) {
			hot.onNext(i);
		}
	}

	private static void pauseMs(long ms) {
		try {
			TimeUnit.MILLISECONDS.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
