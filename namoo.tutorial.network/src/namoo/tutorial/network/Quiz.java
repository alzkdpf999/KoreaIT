package namoo.tutorial.network;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
// https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png에
// 접속해서 이 파일을 내컴퓨터의 C:\Users\Administrator\Downloads 에 저장하시요
public class Quiz {

	static final String urlString = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";

	public static void main(String[] args) {
		InputStream in = null;
		String userHome = null;
		String downloadPath = null;
		String saveFileName = null;
		FileOutputStream out = null;
		
		try {
			URL url  = new URL(urlString);
//			구현하시요.....
			in = url.openStream(); //url 읽기
			userHome = System.getProperty("user.home");
			downloadPath = userHome + File.separator + "Downloads"; //다운로드 위치 나오게하기
			saveFileName = new File(url.getPath()).getName(); //getPath 하면 images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
			//getName 하면 googlelogo_color_272x92dp.png 이게 나옴
			out = new FileOutputStream(downloadPath + File.separator + saveFileName);
			
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();
			
		} catch (MalformedURLException e) {
			System.err.println("해당 파일이 존재하지 않습니다."); //오타 했을시
		} catch (IOException e) {
			System.err.println("네트워크 장애로 파일을 저장할 수 없습니다."); 
		} 
		System.out.println(saveFileName + "파일이 저장되었습니다.");

	}
}
