package books.system.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books.system.demo.dtos.UserDto;
import books.system.demo.model.Book;
import books.system.demo.model.User;
import books.system.demo.service.UserService;

@RestController
@RequestMapping(path = "library")
public class RestControllerHandler {
    @Autowired
    UserService service;

    Book searchByName(final String listName, final String bookName) {
        return null;
    }

    @GetMapping(path = "users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto getUser(@PathVariable final String username) {
        final User user = this.service.findUser(username);
        return user.convert();
    }

    @SuppressWarnings("javadoc")
    @PostMapping(path = "users", consumes = {"application/json"})
    void createUser(@RequestBody UserDto newUser) {
        this.service.createUser(newUser.toEntity(newUser));
    }

    @PutMapping(path = "users")
    void updateUser(@RequestBody UserDto newUser) {
        this.service.updateUser(newUser.toEntity(newUser));
    }

    @DeleteMapping(path = "users/{username}")
    void deleteUser(@PathVariable String username) {
        this.service.deleteUser(username);
    }
}
