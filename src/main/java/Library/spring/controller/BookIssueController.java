package Library.spring.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Library.spring.Repositories.BookIssueRepo;
import Library.spring.Repositories.MemberRepo;
import Library.spring.entities.Book;
import Library.spring.entities.BookIssue;
import Library.spring.entities.Member;
import Library.spring.service.BookIssueService;
import Library.spring.service.BookService;
import Library.spring.service.MemberService;
import jakarta.persistence.EntityNotFoundException;

@Controller
public class BookIssueController {
	 @Autowired
	    private BookIssueService bookIssueService;

	    @Autowired
	    private BookService bookService;

	    @Autowired
	    private MemberService memberService;
	   
	    @RequestMapping("/bookIssueMain")
	    public String showMainPage(Model model) {
	        // You can add additional logic to populate the model if needed
	        return "main";
	    }
	    @GetMapping("/listmember1")
		public String displaymember1(Model m) {
			System.out.println("view page");
			List<Member>li1=memberService.getAllMember();
			m.addAttribute("mem", li1);
			return "listmember1";
		}
	    @GetMapping("/addbookdetails/{memberid}")
	    public String showAddBookDetails(@PathVariable int memberid, Model model) {
	        Member member = memberService.getAllById(memberid);
	        List<Book> book = bookService.getAllBook();
	        model.addAttribute("member", member);
	        model.addAttribute("book", book);
	        return "addbookdetails";
	    }
	    
	    @PostMapping("/saveDetails")
	    public String saveBookIssue(@RequestParam("memberid") int memberid, @RequestParam("bookid") int bookid) {
	        // Retrieve member and book details
	        Member member = memberService.getAllById(memberid);
	        Book book = bookService.getAllById(bookid);

	        // Check if there are available copies
	        if (book.getCopiesAvailable() > 0) {
	            // Update the count of available copies
	            book.setCopiesAvailable(book.getCopiesAvailable() - 1);
	            LocalDate currentDate = LocalDate.now();
	            LocalDate returnDate = currentDate.plusDays(5);

	            // Save the updated book information back to the database
	            bookService.save(book);

	            // Create a BookIssue object and set member and book
	            BookIssue bookIssue = new BookIssue();
	            bookIssue.setMember(member);
	            bookIssue.setBook(book);
	            bookIssue.setIssueDate(currentDate);
	            bookIssue.setReturnDate(returnDate);

	            // Save the book issue details to the database
	            bookIssueService.saveBookIssue(bookIssue);

	            // Redirect to the appropriate page
	            return "redirect:/main"; // Replace with your actual success page
	        } else {
	            // Handle the case when no copies are available
	            return "redirect:/noCopiesAvailablePage"; // Replace with your actual page for no copies available
	        }
	    }
	   
	   
	    @GetMapping("/listbookissue")
	    public String displaymemberandbook(Model m) {
	        System.out.println("view page");

	       
	        List<BookIssue> bookIssues = bookIssueService.getAllMemberAndBook();

	       
	        m.addAttribute("memberandbook", bookIssues);

	   
	        return "listbookissue";
	    }
	    @GetMapping("/returnBook/{id}")
	    public String returnBooks(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
	        try {
	            bookIssueService.returnBook(id);
	            redirectAttributes.addFlashAttribute("successMessage", "Book returned successfully!");
	        } catch (EntityNotFoundException e) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Error returning book: " + e.getMessage());
	        }
	        return "redirect:/listbookissue";
	    }
	 
	  
	    
}