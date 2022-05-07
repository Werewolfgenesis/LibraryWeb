package books.system.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import books.system.demo.model.Book;
import books.system.demo.service.UserService;

@RestController
@RequestMapping("users")
public class RestControllerHandler {
    @Autowired
    UserService service;

    Book searchByName(final String listName, final String bookName) {
        return null;
    }
}
