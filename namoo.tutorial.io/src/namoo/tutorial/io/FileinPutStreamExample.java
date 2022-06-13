package namoo.tutorial.io;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 파일에서 데이터 읽어들이기
public class FileinPutStreamExample {
	public static void main(String[] args) {
		String path = "D:\\lecture\\ee\\license.txt";
		// Stream API를 이용하여 입력 받기
		//		File file = new File(path);
		try {
			FileInputStream fin = new FileInputStream(path); // 읽어드일 준비완료
			//			fin.read() int 반환 한바이트씩 읽어오기 쓸 일 없음 기본
			
			int data=0;
			while((data = fin.read()) != -1) {
				System.out.println(data);
			}
			//			fin.read(byte b[]) 배열로 읽어오기 
			//			fin.read(byte b[], int off, int len)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
