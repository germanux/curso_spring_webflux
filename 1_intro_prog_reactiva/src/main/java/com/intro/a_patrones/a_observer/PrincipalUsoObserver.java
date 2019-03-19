package com.intro.a_patrones.a_observer;

public class PrincipalUsoObserver {
	public static void ejecuta() {
		RedDressObservable almacenRopa = new RedDressObservable();
		
		User u1 = new User("Yolanda");
		User u2 = new User("Christian");

		almacenRopa.addObserver(u1);
		almacenRopa.addObserver(u2);
		
		almacenRopa.notifyObservers();
		// Un dia después...,
		
		almacenRopa.inStock = true;
		almacenRopa.notifyObservers();
		almacenRopa.inStock = false;
		
		User u3 = new User("Esteban");
		almacenRopa.addObserver(u3);
		almacenRopa.notifyObservers();
	}
}
