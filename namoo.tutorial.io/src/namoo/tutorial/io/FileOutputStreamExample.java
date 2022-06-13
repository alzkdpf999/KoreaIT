package namoo.tutorial.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamExample {
	
	static final String PATH = "./sample.txt"; // 어떤 클래스에서든 쓸 수 있게 static
	//변경될 일이 없다 final
	
	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream(PATH); // 다형성을 위해
		OutputStream out1 = new FileOutputStream(PATH,true); // 이렇게 하면 덮어쓰기 안함 
		//생략 가능하지만 true이면기존 파일 뒤에 내용을 추가, fasle이면 덮어쓴다 fasle가 디폴트
		
		out.write(98);
		out.write(99);
		out.write(100);
		out.write(101);//현재는 덮어쓰기를 함
		out.close(); // 다 쓰거나 읽었으면 닫아주기 
		System.out.println("파일 출력 완료..");
	
	}

}
