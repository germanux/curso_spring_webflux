package com.intro.a_ptarones.f_interfazfuncional;

public class UsandoInterfacesFuncionales {
	public static void ejecutarEjemplo() {
		IEstrategia estrategia = (nombre) -> "¡Hola " + nombre;
		
		System.out.println(estrategia.diHolaA("Óscar López"));
		System.out.println(estrategia.diHolaMundo());
	}
}
