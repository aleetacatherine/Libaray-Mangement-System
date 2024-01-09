package Library.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String showMainPage(Model model) {
        // Add any common logic for the main page
        return "main"; // Adjust the view name accordingly
    }
    @GetMapping("/index")
    public String home() {
        return "index";
    }
}