package namoo.tutorial.network;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

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
			} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
