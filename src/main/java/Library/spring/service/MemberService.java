package Library.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import Library.spring.Repositories.BookIssueRepo;
import Library.spring.Repositories.BookRepo;
import Library.spring.Repositories.MemberRepo;
//import Library.spring.entities.BookIssue;
import Library.spring.entities.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberRepo memberRepo;
//	@Autowired
//	BookIssueRepo bookissuerepo;
	
	public void save(Member member) {
		memberRepo.save(member);
		
		
		
	}
	
	public List<Member> getAllMember(){
		return memberRepo.findAll();
}
	
	public void deleteMember(int memberid) {
		memberRepo.deleteById(memberid);
	}
	public Member getAllById(int memberid) {
	return memberRepo.findById(memberid).get();
	}
	public void updateMember(Member mem) {
		
		memberRepo.saveAndFlush(mem);
		
		
	}
	
    
}
