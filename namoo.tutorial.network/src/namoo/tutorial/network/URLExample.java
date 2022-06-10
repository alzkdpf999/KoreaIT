package namoo.tutorial.network;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


/*
 *  Url을 추상화한 클래스
 */
public class URLExample {
	public static void main(String[] args) {
		String address = "https://www.seoul.go.kr/main/index.jsp#top";
		try {
			URL url = new URL(address);
			String protocol = url.getProtocol(); // https
			System.out.println(protocol); 
			System.out.println(url.getPath()); // /main/index.jsp
			System.out.println(url.getPort()); // 없으므로 -1 출력
			System.out.println(url.getHost()); // www.seoul.go.kr
			// url에 실제 데이터 읽어오기
/*
			try {
				InputStream a = url.openStream();
			
					int ch =a.read();
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

*/
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
