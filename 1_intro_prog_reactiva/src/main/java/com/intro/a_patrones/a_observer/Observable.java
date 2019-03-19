package com.intro.a_patrones.a_observer;

public interface Observable {
	void addObserver(Observer obs);
	void removeObserver(Observer obs);
	void notifyObservers();	
}
