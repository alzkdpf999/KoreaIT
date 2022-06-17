package namoo.tutorial.network.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/*
 * 접속 클라이언트와 메세지 송수신을 담당하는 독립적인 스레드
 */
/**
 * @author 정충효
 *
 */
public class ChatThread extends Thread {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private ChatService chatService;

	public ChatThread(Socket socket, ChatService chatService ) throws IOException {
		this.socket = socket;
		this.chatService=chatService;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
	}

	public Socket getSocket() {
		return socket;
	}

	public BufferedReader getIn() {
		return in;
	}

	public PrintWriter getOut() {
		return out;
	}
	/** 
	 * 자기자신 클라이언트에게 메시지 전송
	 * @param message
	 */
	public void sendMessage(String message) {
		out.println(message);
		out.flush();
	}
	@Override
	// 스레드의 메인 메소드 와 동일한 역할
	// 여기서 데이타 주고 받는 역할 하면 된다.
	public void run() {
//		String clientIP = socket.getInetAddress().getHostAddress();
		String data = null;
		try {
			while ((data = in.readLine()) != null) {

				System.out.println("수신데이터 : " + data);
				if (data.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트[" +socket.getInetAddress().getHostAddress() + "]가 접속을 종료합니다.");
					break;
				}
				/* 클라이언트에게 메시지 에코(echo) 이거는 자기 자신에게만
				* out.println(data);
				* out.flush();
				*/
				// 모든 클라언트에게 메시지 전송 chatservice에 들어가야 맞는 코딩
				chatService.sendAllMessage(data);
			}
			socket.close(); // socket.close만 해도 상관없음
		} catch (IOException e) {
			System.err.println("포트 충돌로 서버를 구동할 수 없습니다."); // port 충돌문제가 유력
		}

	}
}
