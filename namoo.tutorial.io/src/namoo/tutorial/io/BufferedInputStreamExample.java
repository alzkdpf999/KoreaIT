
package namoo.tutorial.io;

import java.io.BufferedInputStream;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//  효율적으로 읽기 및 조작
public class BufferedInputStreamExample {
	public static void main(String[] args) {
		String path = "D:/lecture/epp550_3581_64bit.exe";
		try {
			FileInputStream fin = new FileInputStream(path); // node stream
			
			BufferedInputStream bis = new BufferedInputStream(fin);// filter stream 512바이트 만큼 디폴트 
	
//			
//			int data=0;
//			while((data = bis.read()) != -1) {
////				System.out.println(data);
//			}
			
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.mark(0); // 일단 마크
			System.out.println(bis.read()); //1
			System.out.println(bis.read());
			bis.skip(20); //건너뛸려는 바이트 수
			System.out.println(bis.read());
			bis.reset(); //이러면 마킹 위치로 감
			System.out.println(bis.read()); //1부분과 같아짐
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
