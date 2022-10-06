package namoo.springcore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import namoo.springcore.dto.FileParam;

/**
 * 파일 업로드 및 다운로드 처리
 * 
 * @author 정충효
 *
 */
@Controller
public class FileController {

	@Value("${spring.servlet.multipart.location}") // location 안에 값이 들어감 EL사용
	private String location;

	// 업로드 화면
	@GetMapping("/upload")
	public String form() {
		return "FileUpload";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile[] uploadFiles, @RequestParam("writer") String name, Model model)
			throws Exception {
		List<FileParam> list = new ArrayList<>();
		System.out.println(name);
		for (MultipartFile file : uploadFiles) {
			if (!file.isEmpty()) {
				String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
				System.out.println(fileName);
				FileParam fi = new FileParam(fileName, file.getOriginalFilename(), file.getContentType());
				list.add(fi);
				file.transferTo(new File(fileName)); // 이 한줄이면 업로드가능 위에는 디비 저장하기 위해
			}
		}
		model.addAttribute("list", list);
		return "FileUpload-result";
	}

	// 여기부터 다운로드 위는 업로드
	//다운로드 목록 보여주는 매소드
	@GetMapping("/download")
	public String download(Model model) {
		File dir = new File(location);
		File[] list = dir.listFiles();
		model.addAttribute("list",list);
		return "download";
	}
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException{
		Path path = Paths.get(location + "/"+ fileName);
	//만약 디비연결이면  컨텐트타입과 원래 이름 받아오고
		//링크에는 랜덤 섞인 이름을 원래 이름은 보여주기
		String contentType = Files.probeContentType(path);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename(fileName,StandardCharsets.UTF_8).build());
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
		
	}
//이미지 출력
	@GetMapping("/img/{fileName}")
	public ResponseEntity<Resource> imgFile(@PathVariable String fileName) throws IOException{
		Path path = Paths.get(location + "/"+ fileName);
	//만약 디비연결이면 
		String contentType = Files.probeContentType(path);
	
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource resource = new FileSystemResource(path);
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
		
	}
}
