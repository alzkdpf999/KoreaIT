package namoo.springJPA.controller;

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

import namoo.springJPA.entity.FileParam;

/*
 * 파일 업로드 및 다운로드 처리
 */
@Controller
public class FileController {
	
	@Value("${spring.servlet.multipart.location}")
	private String location;
	
	@GetMapping("/upload")
	public String form() {
		return "upload";		
	}
	
	@PostMapping("/upload")
	public String uploadd(@RequestParam MultipartFile[] uploadFiles, @RequestParam String writer, Model model) throws IllegalStateException, IOException {
		System.out.println("작성자 :" + writer);
		List<FileParam> list = new ArrayList<FileParam>();
		for (MultipartFile file : uploadFiles) {
			if(!file.isEmpty()) {
				String fileName =  UUID.randomUUID() + "-" + file.getOriginalFilename();
				String originalFileName = file.getOriginalFilename();
				String contentType = file.getContentType();
				System.out.println(fileName);
				FileParam fileParam = new FileParam(fileName,originalFileName, contentType);
				list.add(fileParam);
				file.transferTo(new File(fileName));
			}			
		}
		model.addAttribute("list", list);
		return "upload-result";		
	}
	
	@GetMapping("/downloads")
	public String download(Model model) {
		File directory = new File(location);
		File[] list = directory.listFiles();
		model.addAttribute("list", list);
		return "downloads";
	}
	
	@GetMapping("/downloads/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) throws IOException {
		Path path = Paths.get(location + "/" + fileName);
		String contentType = Files.probeContentType(path);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentDisposition(ContentDisposition.builder("attachment")
				                         .filename(fileName, StandardCharsets.UTF_8)
				                         .build());
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, contentType);
		Resource  resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<Resource>(resource, httpHeaders, HttpStatus.OK);
	}
	
	// 이미지 출력
	@GetMapping("/images/{name}")
	@ResponseBody
	public ResponseEntity<Resource> showImage(@PathVariable String name) throws IOException {
		Path path = Paths.get(location + "/" + name);
		String contentType = Files.probeContentType(path);
		Resource  resource = new FileSystemResource(path);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, contentType);
		return new ResponseEntity<Resource>(resource, httpHeaders, HttpStatus.OK);
	}
	

}












