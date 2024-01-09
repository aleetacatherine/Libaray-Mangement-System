package Library.spring.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="book_issue")
//@IdClass(BookIssueId.class)
public class BookIssue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	 @Id
//	 private int memberId;

    
    
	 @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "member_member_id")
     private Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_bookid")
    private Book book;
    
    private LocalDate issueDate;
    private LocalDate returnDate;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	

	

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "BookIssue [id=" + id + ", member=" + member + ", book=" + book + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + "]";
	}

	

	
}