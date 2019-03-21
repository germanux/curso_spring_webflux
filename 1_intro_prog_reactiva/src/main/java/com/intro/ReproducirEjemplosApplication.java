package com.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReproducirEjemplosApplication {

	public static void main(String[] args) {
		 SpringApplication.run(ReproducirEjemplosApplication.class, args);
		
		// PrincipalUsoObserver.ejecuta();
		// UsandoObservableFuEv.main();
		// UsandoObservableFutu...
		// CalculosMetodoClasico.calcular();
		// CalculosMetodoFuncional.calcular();
		// UsandoFuturos.ejecutarEjemplo();
		// UsandoInterfacesFuncionales.ejecutarEjemplo();
		// UsandoMonoYFlux.ejecutarEjemplo();
		// UsandoSubscriber.ejemploSubscriber();
		// UsandoCombinacionesFlux.ejecutarEjemplo();
		
		// System.exit(0);
		//lanzarPeticionConWebClient();
	}

	public static void lanzarPeticionConWebClient() {
		WebClient clienteWeb = WebClient.create("http://localhost:8080/api");		
		WebClient.RequestHeadersSpec especificPeticion =
				clienteWeb.method(HttpMethod.GET)
				.uri("/reactive/clientes")
				.body(BodyInserters.fromPublisher(
						Flux.just(new Cliente()), Cliente.class));
		
		Flux<Cliente> clienteResp = especificPeticion.retrieve().bodyToFlux(Cliente.class);
		
		clienteResp.subscribe(cli ->System.out.println(">>>>> " + cli.toString() + "<<<"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(clienteResp.toString());
	}	
}
