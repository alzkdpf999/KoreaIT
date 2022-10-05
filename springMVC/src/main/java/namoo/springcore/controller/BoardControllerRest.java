package namoo.springcore.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 게시판 컨트롤러
 * @author 정충효
 *
 */
@RestController
@RequestMapping("/boards")
public class BoardControllerRest {
	
	//게시글 목록처리
	@GetMapping
	public String List() {
		return "게시판 목록 처리 OK";
	}
	
	@PostMapping
	public String Regist() {
		return "게시판 등록 처리 OK";
	}
	
	@GetMapping("/{boardId}")
	public String Find(@PathVariable String boardId) {
		return boardId + "게시글 검색 OK";
	}
	
	@PatchMapping("/{boardId}")
	public String Update(@PathVariable String boardId) {
		return  boardId + "게시글 수정 OK";
	}
	
	@DeleteMapping("/{boardId}")
	public String Delete(@PathVariable String boardId) {
		return  boardId + "게시글 삭제 OK";
	}
	
}
