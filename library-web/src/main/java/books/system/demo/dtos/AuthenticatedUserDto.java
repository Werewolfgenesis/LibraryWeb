package books.system.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticatedUserDto {
    public UserDto user;
    public String jwt;
}
