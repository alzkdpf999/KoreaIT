package namoo.tutorial.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamExample2 {

	static final String PATH = "./sample.txt"; // 어떤 클래스에서든 쓸 수 있게 static
	//변경될 일이 없다 final

	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream(PATH,true); // 이렇게 하면 덮어쓰기 안함 
		byte[] buffer = new byte[1024]; // 1024개의 0이 저장됨
		for(int i =0; i<buffer.length;i++) {
			buffer[i]= (byte)i; //0부터 1023까지 저장
		}
		out.write(buffer,0,buffer.length-1);
		out.close(); // 다 쓰거나 읽었으면 닫아주기 
		System.out.println("파일 출력 완료..");

	}

}
