package Library.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String showMainPage(Model model) {
      
        return "main"; 
    }
    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
