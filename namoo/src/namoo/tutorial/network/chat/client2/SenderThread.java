package namoo.tutorial.network.chat.client2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * 사용자 키보드 입력 메시지를 읽어들여 
 * Chat Server에 메시지를 전송하는 스레드
 */
public class SenderThread extends Thread {
	private Socket socket;
	private PrintWriter out;
	private String nickName;
	
	public SenderThread(Socket socket, String nickName) throws IOException {
		this.socket = socket;
		out = new PrintWriter(socket.getOutputStream());
		this.nickName = nickName;
	}

	public Socket getSocket() {
		return socket;
	}

	public PrintWriter getOut() {
		return out;
	}
	
	/*
	 * Chat Serverr로 메시지 전송
	 */
	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}
	
	@Override
	/** 사용자 스레드의 엔트리 포인트 */
	public void run() {
//		#1. 입장 메시지 전송
		sendMessage("connect!★!" + nickName);
		Scanner keyboard = new Scanner(System.in);
		String inputMessage = null;
		while ((inputMessage=keyboard.nextLine()) != null) {
			if (inputMessage.equalsIgnoreCase("bye")) {
				break;
			}
			
//			#2. 채팅 메시지 전송
			sendMessage("chat!★!" + nickName + "!★!" +  inputMessage);
			
		}
//		#3. 퇴장 메시지 전송
		sendMessage("disconnect!★!" + nickName);
	}
}