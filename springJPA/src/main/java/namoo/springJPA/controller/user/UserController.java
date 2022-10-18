package namoo.springJPA.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.User;
import namoo.springJPA.repository.user.UserRepository;

@Controller
@Slf4j
@RequestMapping("/pages")
public class UserController {
		@Autowired 
		UserRepository userRepository;
		
		@GetMapping
		public String users(@PageableDefault(size = 5, page = 0) Pageable pageable, @RequestParam(required = false, defaultValue = "") String value, @RequestParam(required = false, defaultValue = "5") int pageCount, Model model) {
			int startPage;
			int endPage;
			
			Page<User> pageResults = userRepository.findUsers(value, value, pageable);
			
			int pageList = pageResults.getNumber()/pageCount;
			
			// (0 ~ 4) = 0 (5 ~ 9) = 1  0부터 시작해서 계산은 이렇게
			startPage = (pageList * pageCount); // 0이면 스타트 0 5페이지이면 5로
			endPage = (pageList * pageCount) + pageCount - 1; // 0이면 4까지 그래야 5이므로 5페이지이면 9까지
			//토탈을 0부터 이므로 1을 뺴주고 시작해서 endPage 만들어주기
			if(endPage > pageResults.getTotalPages() - 1) { 
				endPage = pageResults.getTotalPages() - 1;
			}
			
			
			log.info("pagecount {}",pageCount);
			log.info("현재 페이지{}",pageResults.getNumber());
			log.info("전체 페이지{}",pageResults.getTotalPages());
			
			model.addAttribute("pageResults",pageResults);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			
			return "user/users";
		}
}
