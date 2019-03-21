package com.intro.d_rest_temperatura;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@RestController
public class TemperaturaWebFluxController {

	EmitterProcessor<Temperatura> flujoTemp = EmitterProcessor.create();
	
	// Necesitamos recibir los eventos de temperatura
	@Async	
	@EventListener
	public void capturarMensaje(Temperatura temperatura) {
		flujoTemp.onNext(temperatura);
	}

	@RequestMapping(value = "/temperature-flux", produces = "text/event-stream")
	public Flux<Temperatura> dameTemperaturas() {
		return flujoTemp;
	}
}











