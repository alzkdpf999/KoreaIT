package namoo.tutorial.network.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * Chat Server에서 전송되는 메시지를 수신하여
 * CLI(Command Line Interface)에 출력하는 스레드
 */
public class ReceiverThread extends Thread {
	private Socket socket;
	private BufferedReader in;
	
	public ReceiverThread(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public Socket getSocket() {
		return socket;
	}

	public BufferedReader getIn() {
		return in;
	}

	@Override
	/** 사용자 스레드의 엔트리 포인트 */
	public void run() {
		String receiveMessage = null;
		try {
			while ((receiveMessage=in.readLine()) != null) {
				System.out.println(receiveMessage);
			}
		} catch (IOException e) {
			System.out.println("네트워크 장애로 연결 종료");
		} finally {
			try {
				if (socket != null)	socket.close();
			}catch (Exception e) {}
		}
	}
}