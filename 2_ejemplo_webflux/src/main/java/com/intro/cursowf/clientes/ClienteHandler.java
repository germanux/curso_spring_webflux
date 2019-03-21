package com.intro.cursowf.clientes;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ClienteHandler {
	
	public Mono<ServerResponse> getOne(ServerRequest request) {
		
		Cliente clienteUno = new Cliente("1001", "Fulanito", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5");
		
		Mono<Cliente> monoCliente = Mono.just(clienteUno);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(monoCliente, Cliente.class);
	}
}





