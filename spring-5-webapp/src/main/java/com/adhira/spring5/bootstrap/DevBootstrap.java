package com.adhira.spring5.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.adhira.spring5.models.Author;
import com.adhira.spring5.models.Book;
import com.adhira.spring5.models.Publisher;
import com.adhira.spring5.repositories.AuthorRepository;
import com.adhira.spring5.repositories.BookRepository;
import com.adhira.spring5.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;
  
  @Autowired
  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    super();
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent arg0) {
    init();
  }

  private void init() {
    Publisher foo = new Publisher("foo", "foo:address");
    Publisher bar = new Publisher("bar", "bar:address");
    publisherRepository.save(foo);
    publisherRepository.save(bar);
    
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123", foo);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book j2eeNoEjb = new Book("J2EE Development without EJB", "234", bar);
    rod.getBooks().add(j2eeNoEjb);
    j2eeNoEjb.getAuthors().add(rod);
    authorRepository.save(rod);
    bookRepository.save(j2eeNoEjb);
  }

}
