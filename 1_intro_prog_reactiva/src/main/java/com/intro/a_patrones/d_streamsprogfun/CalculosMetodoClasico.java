package com.intro.a_patrones.d_streamsprogfun;

import java.util.ArrayList;

public class CalculosMetodoClasico {
	public static void calcular() {
		ArrayList<Gasto> lista = new ArrayList<Gasto>();
		lista.add(new Gasto("Port",1000));
		lista.add(new Gasto("libr",15));
		lista.add(new Gasto("Boli",1));
		lista.add(new Gasto("Pantalla",200));
		lista.add(new Gasto("Coche",5000));
		
		float totalMenores2000 = 0;
		for (Gasto g : lista) {
			if (g.getImporte()  < 2000) {
				totalMenores2000 += g.getImporte();
			}
		}
		float ivaMenores2000 = totalMenores2000 * 0.21f;
		System.out.println("ivaMenores2000 = " + ivaMenores2000);
	
		
	}
}
