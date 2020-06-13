package br.com.emc.library.bootstrap;

import br.com.emc.library.domain.Author;
import br.com.emc.library.domain.Book;
import br.com.emc.library.domain.Publisher;
import br.com.emc.library.repository.AuthorRepository;
import br.com.emc.library.repository.BookRepository;
import br.com.emc.library.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("JBC", "Rua da Glória, 300", "São Paulo", "SP");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12344900");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "87472347");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);

        publisherRepository.save(publisher);

        System.out.println(publisher);

    }
}
