package books.system.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {
    @NotEmpty(message = "Note must not be empty")
    public String note;

    @NotEmpty(message = "ISBN must not be empty")
    public String ISBN;
}
