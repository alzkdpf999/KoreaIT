package namoo.springmvc.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 회원 목록 처리
	@GetMapping
	@ResponseBody
	public List<User> list() {
		return userService.findUsers();
	}
}

















