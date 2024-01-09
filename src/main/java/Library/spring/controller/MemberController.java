package Library.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import Library.spring.entities.BookIssue;
import Library.spring.entities.Member;
import Library.spring.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/addmember")
	public String loadRegister(Model m) {
		m.addAttribute("member", new Member());
		//m.addAttribute("book_issue",new BookIssue());
		
		return "addmember";
	}
	
//	@PostMapping("/savedata")
//    public String addMember(@ModelAttribute("member") Member member,Model model) {
//        try {
//            memberService.save(member);
//            model.addAttribute("successMessage", "Member added successfully!");
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Error adding member: " + e.getMessage());
//        }
//        System.out.println("Success Message: " + model.getAttribute("successMessage"));
//
//        return "redirect:/addmember";
//    }
	@PostMapping("/savedata")
	public String addMember(@ModelAttribute("member") Member member, RedirectAttributes redirectAttributes) {
	    try {
	        memberService.save(member);
	        redirectAttributes.addFlashAttribute("successMessage", "Member added successfully!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Error adding member: " + e.getMessage());
	    }

	    return "redirect:/addmember";
	}
	@RequestMapping("/memberMain")
    public String showMainPage(Model model) {
       
        return "main";
    }
	@GetMapping("/listmember")
	public String displaymember(Model m) {
		System.out.println("view page");
		List<Member>li=memberService.getAllMember();
		m.addAttribute("mem", li);
		return "listmember";
	}
	@GetMapping("/deleteMember/{memberid}")
	public String deleteMembers(@PathVariable("memberid") int memberid, RedirectAttributes redirectAttributes) {
	    try {
	        memberService.deleteMember(memberid);
	        redirectAttributes.addFlashAttribute("successDeleteMessage", "Member deleted successfully!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Error deleting member: " + e.getMessage());
	    }
	    return "redirect:/listmember";
	}
	@GetMapping("/editMember/{memberid}")
	public String getEditMember(@PathVariable("memberid") int memberid, Model model) {
	    Member member = memberService.getAllById(memberid);
	    model.addAttribute("member", member);
	    return "editmember"; 
	}
	@PostMapping("/updateMember")
	public String updateMember(@ModelAttribute("member") Member member, RedirectAttributes redirectAttributes) {
	    try {
	        memberService.updateMember(member);
	        redirectAttributes.addFlashAttribute("successEditMessage", "Member edited successfully!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Error editing member: " + e.getMessage());
	    }
	    return "redirect:/listmember";
	}
	

}
