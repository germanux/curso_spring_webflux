package com.intro.a_patrones.a_observer;

public class User implements Observer{
	
	String nombre;
	
	User(String nombre) {
		System.out.println("Hola soy " + nombre);
		this.nombre = nombre;
	}
	@Override
	public void update(boolean inStock) {
		if (inStock)
			System.out.println("Soy " + nombre + " y me dicen que puedo comprar.");
		else
			System.out.println("Soy " + nombre + " y me dicen que tengo que seguir con ropa vieja.");		
	}

}
