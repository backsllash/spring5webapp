package com.backsllash.spring5webapp.bootstrap;

import com.backsllash.spring5webapp.domain.Author;
import com.backsllash.spring5webapp.domain.Book;
import com.backsllash.spring5webapp.domain.Publisher;
import com.backsllash.spring5webapp.repositories.AuthorRepository;
import com.backsllash.spring5webapp.repositories.BookRepository;
import com.backsllash.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher p = new Publisher("ABC Pubs", "1 Maiin Street");

        publisherRepository.save(p);

        Author andre = new Author("Andre Olivier");
        Book il = new Book("Intentional Living", "123");
        il.setPublisher(p);
        andre.getBooks().add(il);
        il.getAuthors().add(andre);
        p.getBooks().add(il);

        authorRepository.save(andre);
        bookRepository.save(il);
        publisherRepository.save(p);

        Author moses = new Author("Moses");
        Book g = new Book("Genesis", "1234");
        g.setPublisher(p);
        moses.getBooks().add(g);
        g.getAuthors().add(moses);
        p.getBooks().add(g);

        authorRepository.save(moses);
        bookRepository.save(g);
        publisherRepository.save(p);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Publisher books: " + p.getBooks().size());

    }
}
