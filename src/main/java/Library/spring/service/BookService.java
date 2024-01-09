package Library.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Library.spring.Repositories.BookRepo;
import Library.spring.entities.Book;
import Library.spring.entities.Member;

@Service
public class BookService {
	@Autowired
	BookRepo bookRepo;
	
	public void save(Book book) {
		bookRepo.save(book);
	}
	
	public List<Book> getAllBook(){
		return bookRepo.findAll();
}
	public void deleteBook(int bookid) {
		bookRepo.deleteById(bookid);
	}
	public Book getAllById(int bookid) {
		return bookRepo.findById(bookid).get();
		}
		public void updateBook(Book book) {
			
			bookRepo.saveAndFlush(book);
			
		}
		
	

}
