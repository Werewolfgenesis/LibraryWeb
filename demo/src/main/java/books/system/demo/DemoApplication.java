package books.system.demo;

import books.system.demo.model.Book;
import books.system.demo.repository.UserRepoImpl;
import books.system.demo.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserServiceImpl userService = new UserServiceImpl(new UserRepoImpl());

		//create a list
		userService.createList("newList");

		//add some books to it
		userService.addBook("newList", new Book());
		userService.addBook("newList", new Book());
		userService.deleteBook("newList", new Book());


		//print books in playlist
		List<Book> books = userService.searchListByName("newList").getBooks();
		books.stream().forEach(b -> System.out.println(b.getAuthor() + " " +
								b.getTitle() + " " +
								b.getGenre() + " " +
								b.getISBN()));
	}
}
