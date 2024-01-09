package Library.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
	 private final Library.spring.Repositories.AdminRepo adminRepo;

	    @Autowired
	    public AdminService(Library.spring.Repositories.AdminRepo adminRepo) {
	        this.adminRepo = adminRepo;
	    }

	    public Library.spring.entities.Admin login(String username, String password) {
	        return adminRepo.findByUsernameAndPassword(username, password);
	    }

}
