package namoo.tutorial.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * url을 추상화한 클래스
 * @author Administrator
 *
 */
public class URLExample {

	public static void main(String[] args) {
		String address = "https://www.seoul.go.kr/main/index.jsp";
		try {
			URL url = new URL(address);
			System.out.println(url.getProtocol());;
			System.out.println(url.getPath());
//			URL에 실제 데이터 읽어들이기...
			try {
				InputStream in = url.openStream();
//				int data = in.read();
//				System.out.println(data);
//				int data = 0;
//				while ((data=in.read()) != -1) {
//					System.out.print((char)data);
//				}
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String txt = null;
				while ((txt=br.readLine()) != null) {
					System.out.println(txt);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		

	}

}





