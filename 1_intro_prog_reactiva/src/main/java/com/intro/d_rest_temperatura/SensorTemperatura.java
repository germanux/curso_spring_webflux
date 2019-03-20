package com.intro.d_rest_temperatura;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SensorTemperatura {
	private final ApplicationEventPublisher publicador;
	private final Random rnd = new Random();
	private final ScheduledExecutorService ejecutor = 
		Executors.newSingleThreadScheduledExecutor();
	
	public SensorTemperatura(ApplicationEventPublisher publicador) {
		this.publicador = publicador;
	}
	@PostConstruct
	public void startProcessing() {
		this.ejecutor.schedule(this::probe, 1, TimeUnit.SECONDS);
	}
	// Calcular temperatura
	public void probe() {
		double temperatura = 16 + rnd.nextGaussian() * 10;	// Número similar a grados
		Temperatura temp = new Temperatura(temperatura);
		
		publicador.publishEvent(temp);
		
		ejecutor.schedule(this::probe, rnd.nextInt(5000), TimeUnit.MILLISECONDS);	
		System.out.println("Temperatura enviada " + temp.getGrados());
	}	
}
