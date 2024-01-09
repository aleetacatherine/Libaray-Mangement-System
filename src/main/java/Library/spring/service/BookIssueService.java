package Library.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Library.spring.Repositories.BookIssueRepo;
import Library.spring.Repositories.BookRepo;
import Library.spring.Repositories.MemberRepo;
import Library.spring.entities.Book;
import Library.spring.entities.BookIssue;
import Library.spring.entities.Member;
import jakarta.persistence.EntityNotFoundException;



@Service
public class BookIssueService {
	@Autowired
    private BookIssueRepo bookIssueRepository;

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepo bookRepo;

    public List<Member> getAllMember(){
		return memberRepo.findAll();
}
    public void saveBookIssue(BookIssue bookIssue) {
        bookIssueRepository.save(bookIssue);
    }
    
    public List<BookIssue> getAllMemberAndBook() {
        // Fetch all BookIssues from the repository
        List<BookIssue> bookIssues = bookIssueRepository.findAll();

        // Calculate and set the return date for each book issue
        for (BookIssue bookIssue : bookIssues) {
            Member member = memberService.getAllById(bookIssue.getMember().getMemberid());
            Book book = bookService.getAllById(bookIssue.getBook().getBookid());

            // Set the fetched Member and Book details in the BookIssue entity
            bookIssue.setMember(member);
            bookIssue.setBook(book);

            // Calculate and set the return date (3 days after the issue date)
          
        }
        return bookIssues;
    }
    public void returnBook(int id) {
        // Fetch the BookIssue entity by ID
        Optional<BookIssue> optionalBookIssue = bookIssueRepository.findById(id);

        if (optionalBookIssue.isPresent()) {
            BookIssue bookIssue = optionalBookIssue.get();

            // Get the associated Book entity
            Book book = bookIssue.getBook();

            if (book != null) {
                // Increment copiesAvailable count
                book.setCopiesAvailable(book.getCopiesAvailable() + 1);
                bookRepo.save(book);
            }

            // Remove the association with Member and Book entities
            bookIssue.setMember(null);
            bookIssue.setBook(null);

            // Save the updated BookIssue entity without the associations
            bookIssueRepository.save(bookIssue);

            // Delete the BookIssue entity
            bookIssueRepository.deleteById(id);
        } else {
            // Handle the case where the BookIssue entity with the given ID is not found
            throw new EntityNotFoundException("BookIssue with ID " + id + " not found");
        }
    }
}
