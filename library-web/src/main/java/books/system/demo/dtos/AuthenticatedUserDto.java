package books.system.demo.dtos;

import books.system.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class AuthenticatedUser {
    public UserDto user;
    public String jwt;
}
