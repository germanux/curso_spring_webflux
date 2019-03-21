package com.intro.cursowf.webclient;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.intro.cursowf.clientes.Cliente;

import reactor.core.publisher.Mono;

public class ProbandoWebClient {

	public static void lanzarPeticionConWebClient() {
		WebClient clienteWeb = WebClient.create("http://localhost:8080/api");		
		WebClient.RequestHeadersSpec especificPeticion =
				clienteWeb.method(HttpMethod.GET)
				.uri("/reactive/cliente")
				.body(BodyInserters.fromPublisher(
						Mono.just(new Cliente()), Cliente.class));
		
		Cliente clienteResp = especificPeticion.retrieve().bodyToMono(Cliente.class).block();
		
		System.out.println(clienteResp.toString());
	}	
}
