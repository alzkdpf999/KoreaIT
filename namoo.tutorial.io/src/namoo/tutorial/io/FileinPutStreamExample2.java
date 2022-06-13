package namoo.tutorial.io;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 파일에서 데이터 읽어드들이기
public class FileinPutStreamExample2 {
	public static void main(String[] args) {
		String path = "D:\\lecture\\ee\\license.txt";
		// Stream API를 이용하여 입력 받기
		//		File file = new File(path);
		try {
			FileInputStream fin = new FileInputStream(path); // 읽어드일 준비완료
			System.out.println(fin.available()); // 무조건 읽기 전에 읽고난 후에 하면 줄어든 만큼만 읽음
			//배열(계란판)로 효율적으로 읽기
			byte[] array= new byte[1024*4];
			int count = 0; // 읽어온 바이트 수를 가져옴
			int fileSize=0;
			while((count =fin.read(array))!=-1) {
				fileSize+=count;
			}
			System.out.println(fileSize);
			//			fin.read(byte b[]) 배열로 읽어오기 
			//			fin.read(byte b[], int off, int len)
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
