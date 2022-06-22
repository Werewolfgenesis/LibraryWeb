package books.system.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;


@SpringBootApplication()
public class LibraryApp {
    public static void main(final String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}
