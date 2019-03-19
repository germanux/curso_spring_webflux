package com.intro.a_patrones.c_iterator;

public class UsandoIteradorRepoNombres {
	public static void probar() {
		RepositorioNombre repoNom = new RepositorioNombre();
		
		for (IteratorCutre iter = repoNom.getIterator();	iter.tieneMas(); ) {
			String nombre = (String) iter.siguiente();
			System.out.println("Nombre: " + nombre);
		}
	}
}
