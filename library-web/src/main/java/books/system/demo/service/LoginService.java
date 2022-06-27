package books.system.demo.service;

import books.system.demo.dtos.UserDto;

public interface LoginService {
    UserDto login(String username, String password);
}
