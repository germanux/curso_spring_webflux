package com.intro.d_rest_temperatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

// Soporte SSE está desde Servlet 3.0
@RestController
public class TemperaturaController {
	// CopyOnWriteArraySet es Thread Safe
	private final Set<SseEmitter> clientes = new CopyOnWriteArraySet<>();
	
	@RequestMapping(value = "/temperature-stream", method = RequestMethod.GET)
	public SseEmitter events(HttpServletRequest peticion) {
		SseEmitter emisor = new SseEmitter();
		clientes.add(emisor);
		// Eliminar el emisor de la lista cuando haya un error o se desconecte
		emisor.onTimeout(() -> clientes.remove(emisor));
		emisor.onCompletion(() -> clientes.remove(emisor));		
		return emisor;
	}
	// Necesitamos recibir los eventos de temperatura
	@Async	
	@EventListener
	public void capturarMensaje(Temperatura temperatura) {
		List<SseEmitter> emisoresMuertos = new ArrayList<>();
		clientes.forEach(emisor -> {
			try {
				emisor.send(temperatura);
			} catch (Exception ignorar) {
				emisoresMuertos.add(emisor);
			}
		});
		clientes.removeAll(emisoresMuertos);
	}
}




