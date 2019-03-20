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
	public final ApplicationEventPublisher publicador;
	private final Random rnd = new Random();
	private final ScheduledExecutorService ejecutor = 
		Executors.newSingleThreadScheduledExecutor();
	
	
	public SensorTemperatura(ApplicationEventPublisher publicador) {
		this.publicador = publicador;
		System.out.println(">>> Constructor SensorTemperatura ");
	}
	@PostConstruct
	public void startProcessing() {
		System.out.println(">>> SensorTemperatura - startProcessing()");
		this.ejecutor.schedule(this::probe, 1, TimeUnit.SECONDS);
		System.out.println(">>> SensorTemperatura - startProcessing() FIN");
		
	}
	// Calcular temperatura
	public void probe() {
		System.out.println(">>> SensorTemperatura - PROBE()");
		double temperatura = 16 + rnd.nextGaussian() * 10;	// Número similar a grados
		Temperatura temp = new Temperatura(temperatura);
		
		publicador.publishEvent(temp);
		
		ejecutor.schedule(this::probe, rnd.nextInt(5000), TimeUnit.MILLISECONDS);	
		System.out.println(">>> SensorTemperatura - PROBE() - Enviado: " + temp.getGrados());
	}	
}
