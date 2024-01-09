package Library.spring.Repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Library.spring.entities.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	 Member findByEmail(String email);
	
	}


