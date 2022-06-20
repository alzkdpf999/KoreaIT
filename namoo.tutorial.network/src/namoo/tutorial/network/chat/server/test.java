package namoo.tutorial.network.chat.server;

import java.io.IOException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		write wr=new write();
		try {
			wr.startUp();
			System.out.println("서버와 연결 성공");
			wr.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
