package com.arsenic.book_store;

import com.arsenic.book_store.entity.Book;
import com.arsenic.book_store.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@SpringBootTest
public class MyAppTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findMethodTest(){
        System.out.println("App Testing in progress");
       // Mono<Book> byName = bookRepository.findByName("Spring Framework");
        Flux<Book> byName = bookRepository.findByAuthor("Arslan");
        StepVerifier.create(byName)
                .expectNextCount(1)
                .verifyComplete();

    }

    @Test
    public void QueryMethodTest(){
        bookRepository.getAllBooksByAuthor("Arslan")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void SearchQueryMethod(){
        bookRepository.searchBookByTitle("%java%")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }


    @Test
    public void flatMapTest(){
        final List<String> items = Lists.newArrayList("a","b","c","d","e","f");

        //final TestScheduler
    }
}
