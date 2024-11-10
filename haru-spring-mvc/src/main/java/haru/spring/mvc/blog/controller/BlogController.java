package haru.spring.mvc.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import haru.spring.mvc.blog.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreate() {
		return "blog/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postCreate(@RequestParam Map<String, Object> map) {
	    int blogContSeq = blogService.create(map);
	    return "redirect:/read/" + String.valueOf(blogContSeq);
	}
	
	@GetMapping(value = "/read/{blogContSeq}")
	public String getRead(@PathVariable("blogContSeq") int blogContSeq, Model model) {
		// TODO: 서비스 클래스에 Map 타입(키(컬럼명)-값(데이터))으로 글 데이터를 반환하는 메서드 만들기
		Map<String, Object> blogCont = blogService.read(blogContSeq);
		model.addAttribute("blogCont", blogCont);
		return "blog/read";
	}
}
