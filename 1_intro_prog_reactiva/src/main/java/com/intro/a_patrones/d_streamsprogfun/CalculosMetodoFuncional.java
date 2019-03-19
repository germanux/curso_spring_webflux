package com.intro.a_patrones.d_streamsprogfun;

import java.util.ArrayList;

public class CalculosMetodoFuncional {
	// https://github.com/germanux/curso_spring_webflux
	public static void calcular() {
		ArrayList<Gasto> lista = new ArrayList<Gasto>();
		lista.add(new Gasto("Port",1000));
		lista.add(new Gasto("libr",15));
		lista.add(new Gasto("Boli",1));
		lista.add(new Gasto("Pantalla",200));
		lista.add(new Gasto("Coche",5000));
		
		double ivaMenores2000 = lista.stream()
				.filter(gasto -> gasto.getImporte() < 2000)
				.mapToDouble(gasto -> gasto.getImporte() * 0.21)
				.sum();
		System.out.println("ivaMenores2000 = " + ivaMenores2000);
	}
}
