package Library.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Library.spring.service.BookIssueService;
import Library.spring.service.BookService;
import Library.spring.service.MemberService;

@Controller
@RequestMapping("/api/dashboard")
public class DashboardController {
	     @Autowired
	    private MemberService memberService;

	    @Autowired
	    private BookService bookService;

	    @Autowired
	    private BookIssueService bookIssueService;

	    @GetMapping("/membersCount")
	    public ResponseEntity<Integer> getMembersCount() {
	        int membersCount = memberService.getAllMember().size();
	        return ResponseEntity.ok(membersCount);
	    }

	    @GetMapping("/booksCount")
	    public ResponseEntity<Integer> getBooksCount() {
	        int booksCount = bookService.getAllBook().size();
	        return ResponseEntity.ok(booksCount);
	    }

	    @GetMapping("/issuesCount")
	    public ResponseEntity<Integer> getIssuesCount() {
	        int issuesCount = bookIssueService.getAllMemberAndBook().size();
	        return ResponseEntity.ok(issuesCount);
	    }
	

}
