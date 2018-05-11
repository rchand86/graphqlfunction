package com.graphql.example.graphservice.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.example.graphservice.model.Author;
import com.graphql.example.graphservice.model.Book;
import com.graphql.example.graphservice.model.BookCategory;
import com.graphql.example.graphservice.repo.AuthorRepository;
import com.graphql.example.graphservice.repo.BookCategoryRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;
    private BookCategoryRepository bookCategoryRepository;

    public BookResolver(AuthorRepository authorRepository, BookCategoryRepository bookCategoryRepository) {
        this.authorRepository = authorRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }
    
    public BookCategory getBookCategory(Book book) {
        return bookCategoryRepository.findById(Long.valueOf(Integer.valueOf(book.getBookCategory().getId()).toString())).get();
    }
}