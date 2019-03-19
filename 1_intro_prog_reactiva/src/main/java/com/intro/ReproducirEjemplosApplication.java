package com.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intro.a_patrones.a_observer.PrincipalUsoObserver;
import com.intro.a_patrones.b_observable.UsandoObservableFuEv;
import com.intro.a_patrones.d_streamsprogfun.CalculosMetodoClasico;
import com.intro.a_patrones.d_streamsprogfun.CalculosMetodoFuncional;

@SpringBootApplication
public class ReproducirEjemplosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReproducirEjemplosApplication.class, args);
		
		// PrincipalUsoObserver.ejecuta();
		// UsandoObservableFuEv.main();
		// UsandoObservableFutu...
		// CalculosMetodoClasico.calcular();
		CalculosMetodoFuncional.calcular();
		
		// System.exit(0);
	}

}