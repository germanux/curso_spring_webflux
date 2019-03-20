package com.intro.b_reactor;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UsandoMonoYFlux {
	public static void ejecutarEjemplo() {
		System.out.println("\n\nEmpezando ejecutarEjemplo\n");
		// ejemploMono();
		// ejemploMono2();
		// ejemploFlux();
		ejemploFlux2();
	}

	public static void ejemploMono() {
		// Vamos a crear un stream de 0...1 elementos
		Mono<String> kingKong = Mono.just("King Kong").log();
		kingKong.subscribe(unDato -> System.out.println(">>> Mostrando a " + unDato));
		System.out.println(">>> Finalizando...");
	}

	public static void ejemploMono2() {
		Publisher<String> miMonoAmedio = Mono.just("Amedio").delayElement(Duration.ofSeconds(1)).log();
		// Flujo guardado en Publisher de un elemento
		Mono<String> miMono = (Mono<String>) miMonoAmedio;
		miMono.subscribe(unDato -> System.out.println(">>> 2 Mostrando a " + unDato));
		miMono.onTerminateDetach(); // Cuando termina, desligamos los subscriptores
		System.out.println(">>> Finalizando suscripción...");
	}

	public static void ejemploFlux() {
		System.out.println(">>> Comienza ejemploFlux...");
		Flux<Integer> generadorAleatorios = Flux.range(1, 6) // de 1 a 6 elemenos serán emitidos
				.delayElements(Duration.ofMillis(500)).map(i -> i) // Math.random())
				// .filter(i -> i < 0.5) // Quitando los mayores de .5
				.log();
		System.out.println("Pausa...");
		/*
		 * try { // Pausa de 3 segundos Thread.sleep(3000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		System.out.println("<<<< Comenzando suscrip 1 ...");
		// Hasta que alguien escucha, el flujo no comienza
		generadorAleatorios.subscribe(numero -> System.out.println(">>> Número " + numero));
		try { // Pausa de 3 segundos
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<<< Comenzando suscrip 2 ...");
		generadorAleatorios.subscribe(numero -> System.out.println(">>> Otro subs " + numero));

		System.out.println(">>> Finalizando suscripción...");
	}

	private static List<String> palabros = Arrays.asList("El", "rápido", "Súper", "López", "voló", "lejos");

	public static void ejemploFlux2() {
		Flux<String> pocosPalabros = Flux.just("Hola", "me llamo Flú", "no soy un mono")
				.delayElements(Duration.ofMillis(1000));
		Flux<String> muchosPalabros = Flux.fromIterable(palabros).delayElements(Duration.ofMillis(700));

		pocosPalabros.subscribe(System.out::println);
		System.out.println();
		muchosPalabros.subscribe(System.out::println);
	}
	
	
}



