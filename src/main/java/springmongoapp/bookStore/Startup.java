package springmongoapp.bookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springmongoapp.bookStore.model.Book;
import springmongoapp.bookStore.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository repository)
	{
		return args -> {
			List<Book> collection = repository.findAll();
			if(collection.isEmpty())
				repository.insert(GenerateInput());
		};
	}


	private List<Book> GenerateInput()
	{
		Book book1 = new Book(
				"9781234567897",
				"Wieża Jaskółki",
				"Andrzej Sapkowski",
				"Fantasy"
		);
		Book book2 = new Book(
				"9781234567861",
				"Pani Jeziora",
				"Andrzej Sapkowski",
				"Fantasy"
		);
		Book book3 = new Book(
				"9781234567235",
				"Rok 1984",
				"George Orwell",
				"Powieść dystopijna"
		);
		Book book4 = new Book(
				"9781234567789",
				"Pan Tadeusz",
				"Adam Mickiewicz",
				"Poezja epicka"
		);
		Book book5 = new Book(
				"9781237367897",
				"Krzyżacy",
				"Henryk Sienkiewicz",
				"Powieść historyczna"
		);
		Book book6 = new Book(
				"9787734567897",
				"Bagno",
				"Przemysław Piotrowski",
				"Kryminał"
		);
		Book book7 = new Book(
				"9786634567897",
				"Sfora",
				"Przemysław Piotrowski",
				"Kryminał"
		);
		Book book8 = new Book(
				"9786634567897",
				"Złota klatka",
				"Camilla Lackberg",
				"Kryminał"
		);

		List<Book> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		bookList.add(book5);
		bookList.add(book6);
		bookList.add(book7);
		bookList.add(book8);

		return bookList;
	}
}
