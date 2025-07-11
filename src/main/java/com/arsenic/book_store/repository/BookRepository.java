package com.arsenic.book_store.repository;

import com.arsenic.book_store.entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {

    Mono<Book> findByName(String name);

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByPublisher(String publisher);

    Flux<Book> findByNameAndAuthor(String name, String author);

    @Query("select * from book_details where author= :author")
    Flux<Book> getAllBooksByAuthor(String author);

    @Query("select * from book_details where name LIKE :title")
    Flux<Book> searchBookByTitle(String title);

}
