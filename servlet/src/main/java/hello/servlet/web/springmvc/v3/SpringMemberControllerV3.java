package hello.servlet.web.springmvc.v3;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	
private final MemberRepository memberRepository = MemberRepository.getInstance();
	
//	@RequestMapping(value = "/new-form", method = RequestMethod.GET)
	@GetMapping("/new-form")
	public String newForm() {
//		return new ModelAndView("new-form");
		return "new-form";  
	}
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String save(
			@RequestParam("username") String username,
			@RequestParam("age") int age,
			Model model) { 
		
		Member member = new Member(username, age);
		memberRepository.save(member);
		
		model.addAttribute("member", member);
		ModelAndView mv = new ModelAndView("save-result");
		mv.addObject("member", member);
		
		return "save-result";
	}
	
//	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping
    public String members(Model model) {
		
        List<Member> members = memberRepository.findAll();
        
        model.addAttribute("members", members);
        return "members";
    }

}
