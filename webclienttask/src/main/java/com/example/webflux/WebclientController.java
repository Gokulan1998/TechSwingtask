package com.example.webflux;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class WebclientController {
	
	@Autowired
	Serviceclass s;
	
	@GetMapping(value = "/getteammatedetails")
	public String get() {
		String url1 = "http://localhost:8083/view";
		WebClient.Builder a = WebClient.builder();
		String sample = a.build().get().uri(url1).retrieve().bodyToMono(String.class).block();
		return sample;
	}

	@PatchMapping(value = "editteammatedetails")
	public String editteammatedetails() throws InterruptedException {
		String url2 = String.format("http://localhost:8083/edit");
		WebClient.Builder b = WebClient.builder();
		String result = b.build().get().uri(url2).retrieve().bodyToMono(String.class).block();
		Thread.sleep(3000);
		return result;
	}

	@GetMapping(value= "getObj/{id}")
	public CompletableFuture<EntityClass> getObj(@PathVariable("id") int id) throws InterruptedException, ExecutionException {
		
		CompletableFuture<EntityClass> one = s.getObj(1);
		CompletableFuture<EntityClass> two = s.getObj(3);
		CompletableFuture<EntityClass> three = s.getObj(4);
		
		CompletableFuture.allOf(one,two,three).join();
		
		System.out.println(one.get().getName() + System.currentTimeMillis());
		System.out.println(two.get().getName() + System.currentTimeMillis());
		System.out.println(three.get().getName() + System.currentTimeMillis());
		
		System.out.println(System.currentTimeMillis());
		
			return s.getObj(id);
	}
}