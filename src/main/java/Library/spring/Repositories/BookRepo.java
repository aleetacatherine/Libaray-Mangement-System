package Library.spring.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Library.spring.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	 Book findByBookName(String bookName);
	

}
