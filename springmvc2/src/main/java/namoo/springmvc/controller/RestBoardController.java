package namoo.springmvc.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class RestBoardController {

	// 게시글 목록 처리
	@GetMapping
	public String list() {
		return "게시판 목록 처리 OK";
	}
	
	// 게시글 등록 처리
	@PostMapping
	public String regist() {
		return "게시판 등록 처리 OK";
	}
	
	// 게시글 상세 조회 처리
	@GetMapping("/{boardId}")
	public String view(@PathVariable String boardId) {
		return "게시판("+boardId+") 상세 처리 OK";
	}
	
	// 게시글 수정 처리
	@PatchMapping("/{boardId}")
	public String update(@PathVariable String boardId) {
		return "게시판("+boardId+") 수정 처리 OK";
	}
	
	// 게시글 수정 처리
	@DeleteMapping("/{boardId}")
	public String delete(@PathVariable String boardId) {
		return "게시판("+boardId+") 삭제 처리 OK";
	}
}





