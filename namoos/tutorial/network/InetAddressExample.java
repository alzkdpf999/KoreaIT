package namoo.tutorial.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress 클래스는 IP Address를 추상화한 클래스이다.
 * @author Administrator
 *
 */
public class InetAddressExample {

	public static void main(String[] args) {
//		내컴떠의 아이피주소 확인하기
		try {
			InetAddress ia = InetAddress.getLocalHost();
			String address = ia.getHostAddress();
			System.out.println("내컴떠 아이피 :"  + address);
			System.out.println(ia.getHostName());
			
			// 구글 아이피
			String domain = "www.google.com";
			InetAddress ia2 = InetAddress.getByName(domain);
			System.out.println(ia2.getHostAddress());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
