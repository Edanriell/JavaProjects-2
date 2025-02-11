package org.example;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DisposableUsage {
	public static void main(String... args) {
		disposable1();
		disposable2();
	}

	private static void disposable1() {
		System.out.println("\ndisposable1():");
		Observable<Integer> obs = Observable.range(1, 5);

		List<Double> list = new ArrayList<>();
		Disposable disposable =
				obs.filter(i -> i % 2 == 0)
						.doOnNext(System.out::println)  // prints 2 and 4
						.map(Math::sqrt)
						.delay(100, TimeUnit.MILLISECONDS)
						.subscribe(d -> {
							if (list.size() == 1) {
								list.remove(0);
							}
							list.add(d);
						});
		System.out.println(disposable.isDisposed()); // prints: false
		System.out.println(list);                    // prints: []

		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(disposable.isDisposed());  // prints: true
		System.out.println(list);                     // prints: [2.0]

	}

	private static void disposable2() {
		System.out.println("\ndisposable2():");
		Observable<Integer> obs = Observable.range(1, 5);

		List<Double> list = new ArrayList<>();
		Disposable disposable =
				obs.filter(i -> i % 2 == 0)
						.doOnNext(System.out::println)  // prints 2 and 4
						.map(Math::sqrt)
						.delay(100, TimeUnit.MILLISECONDS)
						.subscribe(d -> {
							if (list.size() == 1) {
								list.remove(0);
							}
							list.add(d);
						});
		System.out.println(disposable.isDisposed()); // prints: false
		System.out.println(list);                    // prints: []
		disposable.dispose();

		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(disposable.isDisposed());  // prints: true
		System.out.println(list);                     // prints: [2.0]
	}
}
