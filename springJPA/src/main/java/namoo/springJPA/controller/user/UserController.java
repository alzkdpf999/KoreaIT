package namoo.springJPA.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		public String users(@PageableDefault(size = 5, page = 0) Pageable pageable, @RequestParam(required = false, defaultValue = "co") String value, Model model) {
			Page<User> pageResults = userRepository.findUsers(value, value, pageable);
			log.info("첫 페에지{}",pageResults.isFirst());
			log.info("내용{}",pageResults.getContent());
			log.info("사이즈{}",pageResults.getSize());
			model.addAttribute("pageResults",pageResults);
			return "user/users";
		}
}
