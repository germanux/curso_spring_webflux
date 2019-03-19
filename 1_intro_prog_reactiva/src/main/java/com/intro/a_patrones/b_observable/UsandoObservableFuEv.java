package com.intro.a_patrones.b_observable;

import java.util.Observable;
import java.util.Observer;

import static java.lang.System.out;

public class UsandoObservableFuEv {

	public static void main() {

		out.println("Introducir texto >");
		
		FuenteEvento fuenEv = new FuenteEvento();
		fuenEv.addObserver( UsandoObservableFuEv::UnObservador );
		UsandoObservableFuEv.UnObservador(null, "ccccc");
		
		Observer otroOb = new Observer() {			
			@Override
			public void update(Observable o, Object arg) {
				out.println("\nOTRO Observador, Respuesta: "
						+ arg.toString());
			}
		};
		fuenEv.addObserver(otroOb);
		fuenEv.addObserver((Observable obj, Object arg) -> {
			out.println("\nObservador lambda, Respuesta: "
					+ arg.toString());
		});		
		// Después de añdir observadores, invocamos a la fuente de
		// datos, para que "emita" eventos con información
		new Thread(fuenEv).start();
	}
	
	static void UnObservador(Observable obj, 
			Object arg) {
		out.println("\nUn Observador, Respuesta recibida"
				+ arg.toString());
	}
}
