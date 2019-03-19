package com.intro.b_reactor;

import java.time.Duration;
import java.util.Arrays;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class UsandoSubscriber {

	public static void ejemploSubscriber() {
		Subscriber<? super Double> subscriptor = new Subscriber<Double>() {
			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("<<<< EVENTO:  onSubscribe");
				s.request(0);	// Pedimos sólo 6 elementos
			}
			@Override
			public void onNext(Double t) {
				System.out.println("<<<< EVENTO:  onNext " + t + " - " + 1 / t);		
				if (Math.random() < 1) {
					Math.sqrt(-5);
					System.out.println("<<<< MathMathMathMathMathMathMath");		
					int l[] = new int[1] ;
					l[909999] = 1000;
				}
			}
			@Override
			public void onError(Throwable t) {
				System.out.println("<<<< EVENTO ERROR:  "  + t.getMessage());				
			}
			@Override
			public void onComplete() {
				System.out.println("<<<< EVENTO:  onComplete" );				
			}
		};
		Flux<Double> flujoDb = Flux.fromIterable(Arrays.asList(2d,8d,0d,3d, 9.99, 6d, 7d))
				.delayElements(Duration.ofSeconds(1))
				.map(doub -> 1 / doub).log();
		
		// flujoDb.subscribe(System.out::println);
		flujoDb.subscribe(subscriptor);
		// subscriptor.
	}
}
