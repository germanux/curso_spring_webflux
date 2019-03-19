package com.intro.a_patrones.e_concurrencia;

import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AlgunProcesoGigante {
	public static Logger LOG = LoggerFactory.getLogger(AlgunProcesoGigante.class);
	
	private final ExecutorService executor;
	
	public AlgunProcesoGigante(ExecutorService executor) {
		this.executor = executor;
	}
	public Future<String> procesoMuyLargo(String param)
				throws InterruptedException {
		return executor.submit(() -> {
			LOG.info(">>>>   Comenzando procesoMuyLargo");
			// Acceso a BBDD, a un servicio externo...
			TimeUnit.SECONDS.sleep(10);				
			LOG.info(">>>>   Terminando procesoMuyLargo");
			// Valor final entregado:
			return param.concat(" RESULTADO!");	
		});
	}
	
	
}
