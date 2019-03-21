package com.intro.cursowf.clientes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
@EnableWebFlux
@CrossOrigin
public class ClienteRouter {

	// Equivalente a @RestController() y @RequestMapping() pero con
	// Puntos finales funcionales
	@Bean
	public RouterFunction<ServerResponse> monoRouterFuncion_1(ClienteHandler clienteHandler) {
		
		return route()
				.GET(	"/api/reactive/cliente", 
						accept(MediaType.APPLICATION_JSON), 
						clienteHandler::getOne)
				.GET(	"/api/reactive/cliente/{id}", 
						accept(MediaType.APPLICATION_JSON), 
						clienteHandler::getOneConcreto)
				.GET(	"/api/reactive/clientes", 
						accept(MediaType.APPLICATION_JSON), 
						clienteHandler::getAll)
				.build();
	}
/*	// Equivalente a @RestController() y @RequestMapping() pero con
	// Puntos finales funcionales
	@Bean
	public RouterFunction<ServerResponse> monoRouterFuncion_1(ClienteHandler clienteHandler) {
		
		return route(GET("/api/reactive/cliente/{id}")
				.and(accept(MediaType.APPLICATION_JSON)), 
						clienteHandler::getOneConcreto);
	}
	@Bean
	public RouterFunction<ServerResponse> monoRouterFuncion_2(ClienteHandler clienteHandler) {
		
		return route(GET("/api/reactive/clientes")
				.and(accept(MediaType.APPLICATION_JSON)), 
						clienteHandler::getAll);
	}*/
}


