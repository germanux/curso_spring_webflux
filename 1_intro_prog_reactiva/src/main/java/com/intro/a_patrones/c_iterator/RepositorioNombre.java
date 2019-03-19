package com.intro.a_patrones.c_iterator;

public class RepositorioNombre implements Contenedor {
	
	private String misNombres[] = {"Roberto", "juan", 
			"ana", "fulanito"};
	
	private class IteradorNombres implements IteratorCutre {
		int index;
		
		@Override
		public boolean tieneMas() {
			if (index < misNombres.length) return true;
			return false;
		}
		@Override
		public Object siguiente() {
			if (this.tieneMas()) {
				return misNombres[index++];
			}
			return null;
		}
		public Object elmActual() {
			return misNombres[index]; 
		}
	}
	
	@Override
	public IteratorCutre getIterator() {
		// TODO Auto-generated method stub
		return new IteradorNombres();
	}

}
