package namoo.tutorial.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

// 자바 기본 데이터타입별로 쓴 것을 읽어오기 
public class DataInputStreamExample {
	static final String PATH ="./sample3.dat";  
	public static void main(String[] args) throws IOException {
		DataInputStream in =new DataInputStream(new FileInputStream(PATH)); //한 줄로 가능하다.
		boolean isMan = false;
		char gender = 0;
		int age = 0;
		double weight = 0.0;
		String message = null;
		isMan=in.readBoolean();
		gender=in.readChar();
		age=in.readInt();
		weight=in.readDouble();
		message=in.readUTF(); 
		System.out.println(isMan +" "+ gender+" "+age+" "+weight+" "+message);
		in.close();
	}

}
