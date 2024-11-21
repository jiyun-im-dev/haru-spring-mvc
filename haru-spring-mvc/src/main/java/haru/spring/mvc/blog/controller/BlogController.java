package haru.spring.mvc.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import haru.spring.mvc.blog.service.BlogService;
import haru.spring.mvc.blog.vo.BlogEditRequestVo;
import haru.spring.mvc.blog.vo.BlogListRequestVo;
import haru.spring.mvc.blog.vo.BlogListResponseVo;

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
	
	// 사용자가 특정 번호의 글 읽기를 요청한다
	@GetMapping(value = "/read/{blogContSeq}")
	public String getRead(@PathVariable("blogContSeq") int blogContSeq, Model model) {
		// 컨트롤러 ↔ 서비스
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		model.addAttribute("blogCont", blogCont);
		return "blog/read";
	}
	
	@GetMapping(value = "/edit/{blogContSeq}")
	// 리턴 타입이 String이 아니라 ModelAndView인 점에 유의
	public ModelAndView getEdit(@PathVariable("blogContSeq") int blogContSeq) {
		// 속성(attribute)과 뷰(이름 또는 객체)를 동시에 지정할 수 있는 ModelAndView 사용
		ModelAndView mav = new ModelAndView("/blog/edit");
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		
		// 컨텐츠가 존재하지 않으면 리디렉션만 필요하므로 뷰 이름을 지정한다(속성은 필요하지 않음)
		if (blogCont == null) {
			mav.setViewName("/redirect:/list");
			return mav;
		}
		
		mav.addObject("blogCont", blogCont);
		
		// 뷰 이름은 "/blog/edit"이고 blogCont 객체가 들어있는 mav를 리턴한다
		return mav;
	}
	
	@PutMapping
	public String putEdit(BlogEditRequestVo blogEditRequestVo) {
		boolean isEditSuccess = this.blogService.edit(blogEditRequestVo);
		
		// 성공 시 새로고침??
		if (isEditSuccess) {
			return "redirect:/edit" + blogEditRequestVo.getBlogContSeq();
		}
		
		return "redirect:/list";
	}
	
	@DeleteMapping(value = "/delete")
	public String delete(int blogContSeq) {
		blogService.delete(blogContSeq);
		return "redirect:/list";
	}
	
	@GetMapping(value = "/list")
	public String list(BlogListRequestVo blogListRequestVo, Model model) {
		model.addAttribute("blogListRequestVo", blogListRequestVo); // 요청 객체를 모델에 담음
		model.addAttribute("blogListResponseVoList", 
				this.blogService.list(blogListRequestVo)); 			// 응답 객체를 모델에 담음
		
		return "blog/list";
	}	
}
