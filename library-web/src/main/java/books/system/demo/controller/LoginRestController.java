package books.system.demo.controller;

import books.system.demo.dtos.AuthenticatedUserDto;
import books.system.demo.dtos.UserDto;
import books.system.demo.security.JsonWebToken;
import books.system.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("library/login")
public class LoginRestController {
    @Autowired
    private LoginService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticatedUserDto> login(String username, String password) {
        UserDto user = this.service.login(username, password);
        String jwt = JsonWebToken.buildJWT(user.getUsername());

        return new ResponseEntity<>(new AuthenticatedUserDto(user, jwt), HttpStatus.OK);
    }

}
