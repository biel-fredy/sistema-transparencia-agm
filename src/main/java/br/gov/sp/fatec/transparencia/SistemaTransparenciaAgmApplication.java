package br.gov.sp.fatec.transparencia;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SistemaTransparenciaAgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaTransparenciaAgmApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		
		GsonHttpMessageConverter conversor = new GsonHttpMessageConverter();
		
		conversor.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		
		restTemplate.getMessageConverters().add(conversor);
	
		return restTemplate;
	}
}
