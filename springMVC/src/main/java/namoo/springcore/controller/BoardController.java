package namoo.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 게시판 컨트롤러
 * @author 정충효
 *
 */
@Controller
@RequestMapping("/board")
public class BoardController {
	
	//게시판 글쓰기 화면
	@GetMapping("/regist")
	public String Form() {
		return "board/form";
	}
	//게시판 글쓰기 처리
	@PostMapping("/regist")
	public String Regist() {
		return "board/regist";
	}
	
	//게시글 목록처리
	@GetMapping("/list")
	public String List() {
		return "board/list";
	}
	/*
	 * 파라미터 조건 매핑
	 */
	@DeleteMapping(value = "/delete" , params = "admin=bangry")
	@ResponseBody //바로 출력 하는
	public String Delete() {
		return "게시판 삭제 완료";
	}
	/**
	 * 헤더 조건 매핑
	 * @return
	 */
	@GetMapping(value = "/header" , headers = "mode=debug")
	@ResponseBody //바로 출력 하는
	public String HeaderMapping() {
		return "디버깅 모드 실행.";
	}
}
