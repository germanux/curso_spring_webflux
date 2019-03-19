package com.intro.a_patrones.e_concurrencia;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsandoFuturos {
	
	public static void ejecutarEjemplo() {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		AlgunProcesoGigante  procGig = new AlgunProcesoGigante(executor);
		Future<String> objFuturo;
		System.out.println(">>>>> COMENZANDO");
		try {
			objFuturo = procGig.procesoMuyLargo("Por favor, no tardes mucho");
			System.out.println(">>>>> Parece que está haciendo algo");
			String respuestaFutura = objFuturo.get();
			System.out.println(">>>>> Parece que ha terminado: " 
								+ respuestaFutura);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
	}
}
