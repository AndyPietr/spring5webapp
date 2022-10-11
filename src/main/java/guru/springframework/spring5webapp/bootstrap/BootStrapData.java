package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository= publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //        Adding book 1
        Author author1= new Author("Eric", "Evans");
        Book book1= new Book("Design", "123123");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        //        Adding book 2
        Author author2= new Author("Rod", "Johnson");
        Book book2= new Book("Some Title", "123123");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

        //        Adding publisher
        Publisher publisher= new Publisher("asdf", "123","Asdf", "asdf", "Asdf");
        publisher.getBooks().add(book1);
        publisherRepository.save(publisher);


        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of publisher's books: " + publisher.getBooks().size());

    }
}
