
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "books.system.demo.controller", "books.system.demo.dtos", "books.system.demo.model", "books.system.demo.repository",
    "books.system.demo.service"
})
public class LibraryApp {

    public static void main(final String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}
