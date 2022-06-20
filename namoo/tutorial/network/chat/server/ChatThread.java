package namoo.tutorial.network.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/*
 * 접속 클라이언트와 메시지 송수신을 담당하는 독립적인 스레드
 */
public class ChatThread extends Thread {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private ChatService chatService;
	

	public ChatThread(Socket socket, ChatService chatService) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
		this.chatService = chatService;
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
	/** 스레드의 메인메소드와 동일한 역할 */
	public void run() {
		String clientIp = socket.getInetAddress().getHostAddress();
		// 클라이언트 전송데이터 수신
		String message = null;
		try {
			while ((message = in.readLine()) != null) {
				System.out.println("[debug] : 수신데이터: " + message);
				if (message.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트[" + clientIp + "]가 연결을 종료하였습니다.");
					break;
				}
				
				// 모든 클라이언트에게 메시지 전송
				chatService.sendAllMessage(message);
			}
//			socket.close();
		} catch (IOException e) {
			System.out.println("클라이언트[" + socket.getInetAddress().getHostAddress() + "] 네트워크 장애로 연결 종료");
		} finally {
			try {
				if (socket != null)	socket.close();
			} catch (IOException e) {}
		}
	}

}
