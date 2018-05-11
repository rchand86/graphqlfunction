package com.graphql.example.graphservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.graphql.example.graphservice.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
