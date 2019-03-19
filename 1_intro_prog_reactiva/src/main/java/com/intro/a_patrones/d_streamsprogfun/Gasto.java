package com.intro.a_patrones.d_streamsprogfun;

public class Gasto {
	public String nom;
	public float valor;
	public Gasto(String nom, float valor) {
		super();
		this.nom = nom;
		this.valor = valor;
	}
	
	float getImporte() {
		return valor;
	}
}
