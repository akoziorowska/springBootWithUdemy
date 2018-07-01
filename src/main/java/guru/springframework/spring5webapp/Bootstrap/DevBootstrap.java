package guru.springframework.spring5webapp.Bootstrap;

import guru.springframework.spring5webapp.model.Author.Author;
import guru.springframework.spring5webapp.model.Book.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }
    private void initData(){
        Publisher publisher =  new Publisher("Wydawnictwo slask", "Warszawa");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evan");
        Book myBook = new Book("Pinokio", "123",publisher);
        eric.getBooks().add(myBook);
        myBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(myBook);

        Author eric2 = new Author("Eric2", "Evan2");
        Book myBook2 = new Book("Pinokio222", "1232", publisher);
        eric.getBooks().add(myBook2);

        authorRepository.save(eric2);
        bookRepository.save(myBook2);
    }
}
