package com.intro.a_patrones.b_observable;

import java.util.Observable;
import java.util.Scanner;
import static java.lang.System.out;

public class FuenteEvento 
extends Observable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean continuar = true;
		while (continuar) {
			String respuesta = 
					new Scanner(System.in)
					.next();
			setChanged();
			notifyObservers("Has escrito " 
						+ respuesta);
			if (respuesta.isEmpty()) {
				continuar = false;
				out.println("Fin del flujo");
			}
		}
	}
}
