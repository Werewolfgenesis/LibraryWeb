package books.system.demo.controller;

import books.system.demo.convertions.Convertions;
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
    private UserService service;

    @GetMapping(path = "users/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto getUser(@PathVariable final String username) {
        final User user = this.service.findUser(username);
        return Convertions.convertUserToDto(user);
    }


    @PostMapping(path = "users", consumes = {"application/json"})
    UserDto createUser(@RequestBody UserDto newUser) {
        this.service.createUser(newUser.toEntity(newUser));
        return newUser;
    }

    @PutMapping(path = "users")
    UserDto updateUser(@RequestBody UserDto newUser) {
       final User updated = this.service.updateUser(newUser.toEntity(newUser));
       return Convertions.convertUserToDto(updated);
    }

    @DeleteMapping(path = "users/{username}")
    void deleteUser(@PathVariable String username) {
        this.service.deleteUser(username);
    }
}
