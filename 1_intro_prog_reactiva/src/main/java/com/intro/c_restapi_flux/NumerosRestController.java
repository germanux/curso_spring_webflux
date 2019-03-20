package com.intro.c_restapi_flux;

import java.time.Duration;

import org.reactivestreams.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

// http://localhost:8080/numeros

@RestController
public class NumerosRestController {
	@GetMapping(path = "/numeros", produces = "text/event-stream")
	public Flux<Integer> all() {
		Flux<Integer> flux = Flux.range(1, 5)
				.delayElements(Duration.ofSeconds(2));
		
		//  No son necesarios, sólo para mostrar y hacer otra cosa con el flujo
		//flux.subscribe(System.out::println);
		//flux.subscribe(Subscriptor::alCuadrado);
		
		return flux;
	}
}

