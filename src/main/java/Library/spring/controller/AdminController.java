package Library.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class AdminController {
	@Autowired
	 private  Library.spring.service.AdminService adminService;
	
	@GetMapping("/")
    public String showLoginForm() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
    	System.out.println(username);
    	System.out.println(password);
        Library.spring.entities.Admin admin = adminService.login(username, password);
        System.out.println(admin);

        if (admin != null) {
            model.addAttribute("successMessage", "Login successful!");
            return "main";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
            return "index"; 
        }
    }

}
