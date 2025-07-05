package com.arsenic.book_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);

		Mono<String> javaReactiveProgramming = Mono.just("Java Reactive Programming");
		//Mono<Integer> mapped = javaReactiveProgramming.map(item -> item.length());
		//Mono<Integer> mapped = javaReactiveProgramming.flatMap(item -> Mono.just(item.length()));
		Flux<Object> mapped = javaReactiveProgramming.flatMapMany(item -> Flux.just("I", "Love", item));
		mapped.subscribe(System.out::println);

		Flux<Integer> range = Flux.range(1,30);
		range.subscribe(System.out::println);

		Flux<Integer> integerFlux = range.filter(item -> item % 3 == 0);
		integerFlux.subscribe(System.out::println);

	}

}
