package com.arsenic.book_store.controller;

import com.arsenic.book_store.entity.Book;
import com.arsenic.book_store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Mono<Book> create(@RequestBody Book book){
        return bookService.create(book);
    }

    @GetMapping(value = "/bookList",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Book> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/id/{bookId}")
    public Mono<Book> getBookById(int bookId){
        return bookService.get(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int bookId){
        return bookService.update(book, bookId);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable int bookId){
        return bookService.delete(bookId);
    }

    @GetMapping("/search")
    public Flux<Book> searchBookByTitle(
            @RequestParam("query") String query){
        System.out.println(query);
        return this.bookService.searchBooks(query);

    }


    @GetMapping("/search/{query}")
    public Flux<Book> searchBookByTitle2(
            @PathVariable("query") String query){
        System.out.println(query);
        return this.bookService.searchBooks(query);

    }



}
