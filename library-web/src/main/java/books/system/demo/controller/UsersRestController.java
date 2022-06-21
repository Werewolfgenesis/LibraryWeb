package books.system.demo.controller;

import books.system.demo.convertions.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import books.system.demo.dtos.UserDto;
import books.system.demo.service.UserService;

@RestController
@RequestMapping(path = "library/users")
public class UsersRestController {
    @Autowired
    private UserService service;

    @GetMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<UserDto> getUser(@PathVariable final String username) {
        return new ResponseEntity<>(this.service.findUser(username), HttpStatus.OK);
    }


    @PostMapping(consumes = {"application/json"})
    @CrossOrigin
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto newUser) {
        return new ResponseEntity<>(this.service.createUser(Conversions.userToEntity(newUser)),
                HttpStatus.OK);
    }

    @PutMapping()
    @CrossOrigin
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto newUser) {
       return new ResponseEntity<>(this.service.updateUser(Conversions.userToEntity(newUser)),
               HttpStatus.OK);
    }

    @DeleteMapping(path = "/{username}")
    @CrossOrigin
    public void deleteUser(@PathVariable String username) {
        this.service.deleteUser(username);
    }
}
