package Library.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Library.spring.entities.BookIssue;

public interface BookIssueRepo extends JpaRepository<BookIssue, Integer>{

}
