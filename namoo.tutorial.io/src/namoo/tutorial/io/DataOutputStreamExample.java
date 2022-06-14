package namoo.tutorial.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 자바 기본 데이터타입별로 쓰기
public class DataOutputStreamExample {
	static final String PATH ="./sample3.dat";  
	public static void main(String[] args) throws IOException {
		DataOutputStream out =new DataOutputStream(new FileOutputStream(PATH)); //한 줄로 가능하다.
		boolean isMan = true;
		char gender = 'm';
		int age = 23;
		double weight = 11.11;
		String message = "자바 HTML CSS JAVA Script SQL....";
		out.writeBoolean(isMan);
		out.writeChar(gender);
		out.writeInt(age);
		out.writeDouble(weight);
		out.writeUTF(message); 
		//문자만 정상적으로 나옴

		out.close();
		System.out.println("출력완료"); 
	}

}
