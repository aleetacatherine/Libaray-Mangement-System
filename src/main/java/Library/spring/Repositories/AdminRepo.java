package Library.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Library.spring.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{
	 Admin findByUsernameAndPassword(String username, String password);

}
