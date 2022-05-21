
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import books.system.demo.service.UserService;

@SpringBootApplication(scanBasePackages = {
    "books.system.demo.controller", "books.system.demo.dtos", "books.system.demo.model", "books.system.demo.repository",
    "books.system.demo.service"
})
@EntityScan(basePackages = "books.system.demo.model")
public class LibraryApp {
    UserService service;

    public static void main(final String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }

    @Autowired
    public LibraryApp(final UserService service) {
        this.service = service;
    }
}
