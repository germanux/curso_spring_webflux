package com.intro.b_reactor;

import java.time.Duration;
import java.util.ArrayList;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UsandoCombinacionesFlux {

	public static void ejecutarEjemplo() {
		System.out.println("\n\nEmpezando ejecutarEjemplo\n");
		
		// ejemplo12Monos2Flux();
		// ejemploZip();
		// ejemploMerge();
		ejemploAdd();
	}
	public static void ejemplo12Monos2Flux() {
		Mono<String> mono1 = Mono.just("1 King kong\n");
		Mono<String> mono2 = Mono.just("2 Amedio\n");
		Mono<String> mono3 = Mono.just("3 orangután\n");
		Mono<String> mono4 = Mono.just("4 Macaco\n");
	
		Flux<String> flujo4monos = Flux.concat(mono1, mono2,mono3,mono4)
				.delayElements(Duration.ofMillis(1000));
		flujo4monos.subscribe(System.out::println);
		
		Flux<String> flujo8monos = Flux.range(1, 8)
				.map(i -> "Mono ".concat(String.valueOf(i + 4)))
				.delayElements(Duration.ofMillis(500));
		Flux<String> flujo12monos;
		flujo12monos = Flux.concat(flujo4monos, flujo8monos);
		flujo12monos.subscribe(System.out::println);
	}
	public static void ejemploZip() {
		Flux<String> fluxLetras = Flux.just("A", "B", "C");
		Flux<String> fluxNums = Flux.just("1", "2", "3");
		if (fluxLetras.count() == fluxNums.count()) 
		{
			Flux<String> fluxAlfaZip = Flux.zip(fluxLetras, fluxNums,
					(x, y) -> "<" + x + " + " + y + ">");
			fluxAlfaZip.subscribe(System.out::println);			
		}
	}
	public static void ejemploMerge() {
		System.out.println("Ejemplo MERGE");
		int min = 1, max = 20;
		Flux<Integer> eventPares= Flux.range(min, max)
				.filter(x -> x % 2 == 0)
				.delayElements(Duration.ofMillis(333));
		
		Flux<Integer> eventImpares= Flux.range(min, max)
				.filter(x -> x % 2 == 1)
				.delayElements(Duration.ofMillis(500));
		
		Flux<Integer> fluxDeEnteros = Flux.merge(eventPares,eventImpares);
		fluxDeEnteros.subscribe(System.out::println);	
		// Salida: Pares terminan antes: 2, 1, 4, 6,	3	8	5	10	12	7	14	9	16	18	11	20	13	15	17		19
	}
	
	public static void ejemploAdd() {
		System.out.println("Ejemplo Add");
		ArrayList<Integer> listaFinal = new ArrayList<Integer>();
		int min = 1, max = 200;
		Flux<Integer> eventPares= Flux.range(min, max)
				.filter(x -> x % 2 == 0)
				.delayElements(Duration.ofMillis(5));

		eventPares.subscribe(System.out::println);
		eventPares.subscribe(x -> System.out.println("Actualmente: " + listaFinal.toString()));	
		eventPares.subscribe(listaFinal::add);	
	}
}






