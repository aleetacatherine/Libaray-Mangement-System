package Library.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Library.spring.entities.Book;
import Library.spring.entities.Member;
import Library.spring.service.BookService;


@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	@GetMapping("/addbook")
	public String loadRegister(Model m) {
		m.addAttribute("book", new Book());
		
		return "addbook";
	}

	@PostMapping("/savedatabook")
    public String addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        try {
              bookService.save(book);
            redirectAttributes.addFlashAttribute("successMessage", "Book added successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error adding book: " + e.getMessage());
        }
        return "redirect:/addbook";
    }
	
	@RequestMapping("/bookMain")
    public String showMainPage(Model model) {
        // You can add additional logic to populate the model if needed
        return "main";
    }
	@GetMapping("/listbook")
	public String displaybook(Model m) {
		System.out.println("view page");
		List<Book>li=bookService.getAllBook();
		m.addAttribute("boo", li);
		return "listbook";
	}
	@GetMapping("/deleteBook/{bookid}")
	public String deleteBooks(@PathVariable("bookid") int bookid, RedirectAttributes redirectAttributes) {
	    try {
	        bookService.deleteBook(bookid);
	        redirectAttributes.addFlashAttribute("successDeleteMessage", "Book deleted successfully!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Error deleting book: " + e.getMessage());
	    }
	    return "redirect:/listbook";
	}
	
	@GetMapping("/editBook/{bookid}")
	public String getEditBook(@PathVariable("bookid") int bookid, Model model) {
	    Book book = bookService.getAllById(bookid);
	    model.addAttribute("book",book);
	    return "editbook"; // Assuming the edit page is named "editmember.html"
	}
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
	    try {
	        bookService.updateBook(book);
	        redirectAttributes.addFlashAttribute("successEditMessage", "Book edited successfully!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Error editing book: " + e.getMessage());
	    }
	    return "redirect:/listbook";
	}
	



}
