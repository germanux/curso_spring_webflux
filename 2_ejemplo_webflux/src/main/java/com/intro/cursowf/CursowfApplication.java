package com.intro.cursowf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intro.cursowf.webclient.ProbandoWebClient;

@SpringBootApplication
public class CursowfApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursowfApplication.class, args);
		
		ProbandoWebClient.lanzarPeticionConWebClient();
	}

}
