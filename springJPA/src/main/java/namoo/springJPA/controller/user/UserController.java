package namoo.springJPA.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import namoo.springJPA.entity.user.User;
import namoo.springJPA.service.user.UserService;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	// 회원 목록 처리
	@GetMapping
	public String list(Model model,HttpSession session) {
		session.setAttribute("test", "testCheck");
		List<User> list = userService.findUsers();
		log.info("사용자 리스트: {}", list);
		model.addAttribute("users", list);
		log.info("세션:{}",session.getAttribute("test"));
		return "user/users";
	}

	//회원 검색
	@GetMapping("/search")
	public String search(@RequestParam(value = "id", required = false) String id, Model model) {
		User searchUser = userService.findUser(id);
		log.info("사용자 리스트: {}", searchUser);
		model.addAttribute("user", searchUser);
		return "user/users";
	}

	// 회원 상세정보
	@GetMapping("/{id}")
	public String find(@PathVariable String id, Model model,
			@RequestParam(value = "result", required = false) boolean result,HttpSession session) {
		User detailUser = userService.findUser(id);
		model.addAttribute("user", detailUser);
		model.addAttribute("result", result);
		log.info("세션:{}",session.getAttribute("test"));
		return "user/detailUserView";
	}

	/**
	 * 회원가입 처리 유효성 검증르 js와 서버에서 두번한다. (나중에 구현) class 타입이 첫글자가 소문자로 바뀌면서 user로 이름이
	 * 들어가짐 RedirectAttributes 는 리다이렉트시 저장해줌
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/form")
	public String regist(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		userService.registUser(user);
		User us = userService.findUser(user.getId());
		redirectAttributes.addAttribute("id", user.getId()); // 이것들은 쿼리스트링으로 나옴
		redirectAttributes.addAttribute("name", user.getName());
		// http://localhost/users/spring3?name=spring3&email=spring3%40naver.com&regdate=2022-10-11+21%3A36%3A55+%ED%99%94%EC%9A%94%EC%9D%BC
		// 이런식으로 나옴

		redirectAttributes.addAttribute("email", user.getEmail());
		redirectAttributes.addAttribute("regdate", us.getRegdate());
		redirectAttributes.addAttribute("result", true);
		return "redirect:/users/{id}";
	}

	// 회원가입 뷰
	@GetMapping("/form")
	public String form() {
		
		return "user/registForm";
	}

	// 회원 수정 뷰
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		User editUser = userService.findUser(id);
		model.addAttribute("id",editUser.getId());
		model.addAttribute("name", editUser.getName());
		model.addAttribute("email",editUser.getEmail());
		log.info("수정전 {}", editUser);
		return "user/editForm";
	}

	// 회원정보 수정
	@PostMapping("/edit")
	public String edited(@ModelAttribute("user") User user,@RequestParam("fixuser") String fixuser) {
		Map<String, Object> map = new HashMap<>();
		map.put("user",user);
		map.put("id", fixuser);
		userService.updateUser(map);
		return "redirect:/users";
	}
	
	
}
