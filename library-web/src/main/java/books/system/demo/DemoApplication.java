package books.system.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import books.system.demo.model.Book;
import books.system.demo.repository.UserRepoImpl;
import books.system.demo.service.UserServiceImpl;

@SpringBootApplication

public class DemoApplication implements CommandLineRunner {

	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		final UserServiceImpl userService = new UserServiceImpl(new UserRepoImpl());

		// create a list
		userService.createList("newList");

		// add some books to it
		userService.addBook("newList", new Book());
		userService.addBook("newList", new Book());
		userService.deleteBook("newList", new Book());

		// print books in playlist
		final List<Book> books = userService.searchListByName("newList").getBooks();
		books.stream().forEach(
				b -> System.out.println(b.getAuthor() + " " + b.getTitle() + " " + b.getGenre() + " " + b.getISBN()));
	}
}
