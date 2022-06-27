package books.system.demo.service;

import books.system.demo.convertions.Conversions;
import books.system.demo.dtos.UserDto;
import books.system.demo.model.User;
import books.system.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto login(String username, String password) {
        User found = this.userRepo.findById(username).orElseThrow(() -> {
            throw new IllegalArgumentException("No such user!");
        });

        if (found.getPassword().equals(password)){
            return Conversions.convertUserToDto(found);
        }
        throw new IllegalArgumentException("No such user found!");
    }
}
