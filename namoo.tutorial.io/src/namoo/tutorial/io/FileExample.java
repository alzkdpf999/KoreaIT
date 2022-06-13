package namoo.tutorial.io;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
//https://lifeinprogram.tistory.com/19 getProperty 사용법을 위한 사이트
//파일(디렉토리) 정보 조회 및 조작
public class FileExample {

	public static void main(String[] args) throws IOException {
		//파일 조회
		String path = System.getProperty("user.dir"); // 현재 디렉토리 가져오기 동적으로
		System.out.println(path);
		Properties pro=System.getProperties(); //hash table 확장 맵 계열 파일저장할때 String 구조로만 
		Enumeration<Object> e = pro.elements(); //Enumration 열거된 데이터를 저장 value 가져오기
		Enumeration<Object> keys = pro.keys(); // 키값 가져오기
	/*	while(e.hasMoreElements()) { //열거된 데이터를 가져올 때 가져올게 있는지 없는지 검사
			String element =(String) e.nextElement(); //가져올게 있으면 가져와라  (value)
			System.out.println(element);
		}
		*/
		while(keys.hasMoreElements()) {
			String key=(String) keys.nextElement();
			String value= pro.getProperty(key);
			System.out.println(key + " = " + value);
		}

		File file= new File("sample.txt");

		//		System.out.println("getName():" +file.getName()); //경로명에 있는 마지막 이름
		//		System.out.println("getParent():" +file.getParent());//경로명에서 마지막 이름 제외한 나머지들
		//		System.out.println("getPath():" +file.getPath()); //경로명 얻기
		//		System.out.println("getAbsolutePath():" +file.getAbsolutePath()); // 절대경로명
		//		System.out.println("getCanonicalPath():" +file.getCanonicalPath());
		//		System.out.println("length():" +file.length()+"bytes"); // 파일 크기
		//		System.out.println("isFile():" +file.isFile()); // 파일인지 아닌지
		//		System.out.println("isDirectory():" +file.isDirectory()); //디렉토리인지 아닌지
	}

}
