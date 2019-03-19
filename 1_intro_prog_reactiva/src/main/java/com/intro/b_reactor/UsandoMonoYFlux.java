package com.intro.b_reactor;

import java.time.Duration;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UsandoMonoYFlux {
	public static void ejecutarEjemplo() {
		System.out.println("\n\nEmpezando ejecutarEjemplo\n");
		// ejemploMono();
		// ejemploMono2();
		ejemploFlux();
	}
	
	public static void ejemploMono() {
		// Vamos a crear un stream de 0...1 elementos
		Mono<String> kingKong = Mono.just("King Kong").log();
		kingKong.subscribe(unDato -> System.out.println(">>> Mostrando a " + unDato));
		System.out.println(">>> Finalizando...");
	}
	public static void ejemploMono2() {
		Publisher<String> miMonoAmedio = Mono.just("Amedio")
				.delayElement(Duration.ofSeconds(1)).log();
		// Flujo guardado en Publisher de un elemento
		Mono<String> miMono = (Mono<String>) miMonoAmedio;
		miMono.subscribe(unDato -> System.out.println(">>> 2 Mostrando a " + unDato));
		miMono.onTerminateDetach();	// Cuando termina, desligamos los subscriptores
		System.out.println(">>> Finalizando suscripción...");
	}
	
	public static void ejemploFlux() {
		System.out.println(">>> Comienza ejemploFlux...");
		Flux<Double> generadorAleatorios = Flux.range(1, 6)	// de 1 a 6 elemenos serán emitidos
				.delayElements(Duration.ofMillis(500))
				.map( i -> Math.random())
				.log();
		System.out.println("Pausa...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Comenzando suscrip...");
		// Hasta que alguien escucha, el flujo no comienza
		generadorAleatorios.subscribe(numero -> System.out.println(">>> Número " + numero));
		
		System.out.println(">>> Finalizando suscripción...");
	}
}









