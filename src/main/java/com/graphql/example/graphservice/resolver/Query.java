package com.graphql.example.graphservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.example.graphservice.model.Author;
import com.graphql.example.graphservice.model.Book;
import com.graphql.example.graphservice.model.BookCategory;
import com.graphql.example.graphservice.repo.AuthorRepository;
import com.graphql.example.graphservice.repo.BookCategoryRepository;
import com.graphql.example.graphservice.repo.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private BookCategoryRepository bookCategoryRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
    
    public Iterable<BookCategory> findAllCategory(){
    	return bookCategoryRepository.findAll();
    }
}