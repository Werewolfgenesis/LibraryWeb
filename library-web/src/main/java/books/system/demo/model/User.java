package books.system.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Setter
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "Username", nullable = false)
	private String username;
	@Id
	@Column(name = "Password", nullable = false)
	private String password;
	@Column(name = "Notes", nullable = true)
	private Map<Book, String> notes;
	@Column(name = "Lists", nullable = true)
	private List<BookCollection> lists;

	public User() {
		this.notes = new HashMap<>();
		this.lists = new ArrayList<>();
	}
}
