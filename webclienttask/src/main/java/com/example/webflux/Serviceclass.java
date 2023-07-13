package com.example.webflux;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class Serviceclass {
	
	@Async("threadPoolTaskExecutor")
	public CompletableFuture<EntityClass> getObj(int id) throws InterruptedException {
	
		//String url2 = "http://localhost:8083/get/%id", id;
		//WebClient.Builder b = WebClient.builder();
		
	
		EntityClass obj = null;
	WebClient webClient = WebClient.create("http://localhost:8083/edit");

	try {
		 obj = webClient.get()
	            .uri("/get/{id}", id)
	            .retrieve()
	            .bodyToMono(EntityClass.class)
	            .block(); 
	} catch (WebClientResponseException ex) {
	    System.out.println(ex);
	}
	
	return CompletableFuture.completedFuture(obj);
	
	}
}
