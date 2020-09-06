package com.backsllash.spring5webapp.repositories;

import com.backsllash.spring5webapp.domain.Author;
import com.backsllash.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
