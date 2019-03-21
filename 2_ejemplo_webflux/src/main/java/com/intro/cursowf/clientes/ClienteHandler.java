package com.intro.cursowf.clientes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
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

	public Mono<ServerResponse> getOneConcreto(ServerRequest request) {
		
		List<Cliente> repoClientes = new ArrayList<Cliente>();	
		repoClientes.add(new Cliente("1001", "Fulanito", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));	
		repoClientes.add(new Cliente("1002", "Menganito", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));	
		repoClientes.add(new Cliente("1003", "Juanita", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));	
		repoClientes.add(new Cliente("1004", "Paco", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));
		
		int idCliente = Integer.valueOf(request.pathVariable("id"));

		Flux<Cliente> fluxClientes = Flux.fromIterable(repoClientes)
				.filter(cli -> String.valueOf(idCliente).equals(cli.getId()));
		// Devolver un único elemento del Flux, 
		// seleccionando por ID
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(fluxClientes, Cliente.class);
	}

	public Mono<ServerResponse> getAll(ServerRequest request) {
		
		List<Cliente> repoClientes = new ArrayList<Cliente>();	
		repoClientes.add(new Cliente("1001", "Fulanito", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));	
		repoClientes.add(new Cliente("1002", "Menganito", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));	
		repoClientes.add(new Cliente("1003", "Juanita", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));	
		repoClientes.add(new Cliente("1004", "Paco", "De Tal y Tal", 
				9166644, "C/Lugar de Madrid, 5"));
		
		Flux<Cliente> fluxClientes = Flux.fromIterable(repoClientes);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(fluxClientes, Cliente.class);
	}	
}





