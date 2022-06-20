package namoo.tutorial.network.chat.server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class write {
	static final String IP = "192.168.45.117"; //=localhost 저기 숫자는 가상 컴퓨터 (집컴)
	static final String IP2= "192.168.7.101";//선생님 ip
	static final String IP3= "192.168.7.16"; // 학원 컴퓨터 IP
	static final int PORT = 2022;
	private Socket socket ;
	public write() {
		
	}
	public void startUp() throws UnknownHostException, IOException {
		this.socket= new Socket(IP3,PORT);
	}
	
	public void connect() {
		try {
			Thread thread = new Thread(socket);
			thread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
