package com.graphql.example.graphservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.graphql.example.graphservice.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
