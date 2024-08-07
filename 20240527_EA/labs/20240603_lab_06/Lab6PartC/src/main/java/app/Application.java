package app;

import domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StopWatch;
import repository.BookRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		addBooks();
		changeLocationCode();
		removeOldBooks();
	}

	public void addBooks(){
		StopWatch sw = new StopWatch();
		sw.start();

		for (int x=0; x< 10000; x++){
			int year = 1900 + new Random().nextInt(100-1) + 1;;
			bookRepository.save( new Book("Harry Potter"+x, "J.K. Rowling"+x, "AA-345-"+x, year));
		}

		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Inserting all books took "+totaltime+" ms");

	}

	private void changeLocationCode() {
		StopWatch sw = new StopWatch();
		sw.start();

		bookRepository.updateBooksLocationCode("BB");

		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Changing the location code of all books took "+totaltime+" ms");
	}

	private void removeOldBooks() {
		StopWatch sw = new StopWatch();
		sw.start();


		bookRepository.deleteAllByPublicationYearBefore(1950);


		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Removing old books took "+totaltime+" ms");
	}

}

