package com.intro.a_patrones.a_observer;

import java.util.ArrayList;

public class RedDressObservable implements Observable {
	boolean inStock;
	ArrayList<Observer> usuarios;
	
	
	public RedDressObservable() {
		super();
		usuarios = new ArrayList<Observer>();		
	}
	@Override
	public void addObserver(Observer obs) {
		usuarios.add(obs);		
	}
	@Override
	public void notifyObservers() {
		for (Observer o : usuarios) {
			o.update(inStock);
		}
	}
	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	
}
