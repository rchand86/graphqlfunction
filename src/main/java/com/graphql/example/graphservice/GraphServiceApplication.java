package com.graphql.example.graphservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphql.example.graphservice.model.Author;
import com.graphql.example.graphservice.model.Book;
import com.graphql.example.graphservice.model.BookCategory;
import com.graphql.example.graphservice.repo.AuthorRepository;
import com.graphql.example.graphservice.repo.BookCategoryRepository;
import com.graphql.example.graphservice.repo.BookRepository;
import com.graphql.example.graphservice.resolver.BookResolver;
import com.graphql.example.graphservice.resolver.Mutation;
import com.graphql.example.graphservice.resolver.Query;

@SpringBootApplication
public class GraphServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphServiceApplication.class, args);
	}
		
		@Bean
		public BookResolver authorResolver(AuthorRepository authorRepository, BookCategoryRepository bookCategoryRepository) {
			return new BookResolver(authorRepository, bookCategoryRepository);
		}

		@Bean
		public Query query(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
			return new Query(authorRepository, bookRepository, bookCategoryRepository);
		}

		@Bean
		public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository){
			return new Mutation(authorRepository, bookRepository,bookCategoryRepository);
		}
		
		 @Bean
			public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
				return (args) -> {
					Author author = new Author("Herbert", "Schildt");
					authorRepository.save(author);
					
					BookCategory category = new BookCategory();
					category.setName("Java");
					bookCategoryRepository.save(category);

					bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author, category));
				};
			}
	
}
