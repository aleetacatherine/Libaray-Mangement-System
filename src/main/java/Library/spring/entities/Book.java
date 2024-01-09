package Library.spring.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	private String categoryName;
	private String bookName;
	private String authorName;
	private int copiesAvailable; 
	
	 
    public int getCopiesAvailable() {
	return copiesAvailable;
	    }

	 public void setCopiesAvailable(int copiesAvailable) {
	 this.copiesAvailable = copiesAvailable;
	    }
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
    public String toString() {
        return "Book [bookid=" + bookid + ", categoryName=" + categoryName + ", bookName=" + bookName
                + ", authorName=" + authorName + ", copiesAvailable=" + copiesAvailable + "]";
    }
	

}
