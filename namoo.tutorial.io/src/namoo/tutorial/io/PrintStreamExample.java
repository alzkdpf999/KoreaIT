package namoo.tutorial.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
// 자바 기본 데이터타입들을 OS 인코딩 방식에 맞춰 출력 
public class PrintStreamExample {
	static final String PATH ="./sample4.txt";  
	public static void main(String[] args) throws IOException {

		File file =new File(PATH);
		//1. PrintStreamt out =new PrintStream(new FileOutputStream(PATH)); 
		//2. PrintStream out =new PrintStream(PATH); 
		PrintStream out =new PrintStream(file); //3. 세가지 모두 가능
		
		boolean isMan = true;
		char gender = 'm';
		int age = 23;
		double weight = 11.11;
		String message = "자바 HTML CSS JAVA Script SQL....";
//		out.print();
//		out.println();
//		out.printf();
		out.println(isMan);
		out.println(gender);
		out.println(age); //문자열 출력
		out.println(weight); // 문자열 출력 
		out.println(message);
		out.close();
		System.out.println("출력완료"); 
	}

}
