package com.graphql.example.graphservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.graphql.example.graphservice.model.BookCategory;

public interface BookCategoryRepository extends CrudRepository<BookCategory, Long>{

}
