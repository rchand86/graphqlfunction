package com.graphql.example.graphservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.example.graphservice.model.Author;
import com.graphql.example.graphservice.model.Book;
import com.graphql.example.graphservice.model.BookCategory;
import com.graphql.example.graphservice.repo.AuthorRepository;
import com.graphql.example.graphservice.repo.BookCategoryRepository;
import com.graphql.example.graphservice.repo.BookRepository;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private BookCategoryRepository bookCategoryRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }
    
    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId, int bookCategory) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setBookCategory(new BookCategory(bookCategory));
        book.setPageCount(pageCount != null ? pageCount : 0);
        bookRepository.save(book);
        return book;
    }
    
    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
    
    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).get();
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
    
    public BookCategory newBookCategory(String name) {
    	BookCategory bookCategory = new BookCategory();
    	bookCategory.setName(name);
    	BookCategory category = bookCategoryRepository.save(bookCategory);
    	return category;
    }
}
