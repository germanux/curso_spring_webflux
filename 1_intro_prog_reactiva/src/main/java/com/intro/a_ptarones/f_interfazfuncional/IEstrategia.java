package com.intro.a_ptarones.f_interfazfuncional;

// Esta interfaz ya es funcional, porque tiene un único método abstracto

@FunctionalInterface
public interface IEstrategia {
	
	public String diHolaA(String nombre);
	
	public default String diHolaMundo() {
		return "Hola mundo!";
	}
}
