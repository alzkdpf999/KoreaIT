package namoo.tutorial.network.chat.server2;

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
	
	private String clientIp;
	

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
		clientIp = socket.getInetAddress().getHostAddress();
		// 클라이언트 전송데이터 수신
		String message = null;
		try {
			while ((message = in.readLine()) != null) {
				System.out.println("[debug] : 수신데이터: " + message);
//				송수신 메시지 형식(command!★!senderNickname!★!Message)				
//				메시지 파싱(Parsing)
				String[] elements = message.split("!★!");
				String command = elements[0];
				String messageSender = elements[1];
				switch (command) {
				case "connect":
					chatService.sendAllMessage("♥♥♥♥♥ ["+messageSender+"]님이 입장하였습니다 ♥♥♥♥♥");
					break;
				case "chat":
					String chatMessage = elements[2];
					chatService.sendAllMessage("["+messageSender+"] : " + chatMessage);
					break;
				case "disconnect":
					chatService.removeClient(this);
					chatService.sendAllMessage("##### ["+messageSender+"]님이 퇴장하였습니다 #####");
					return;
				}
				
			}
//			socket.close();
		} catch (IOException e) {
			System.out.println("클라이언트[" + clientIp + "] 네트워크 장애로 연결 종료");
		} finally {
			try {
				if (socket != null)	socket.close();
				System.out.println("클라이언트["+clientIp+"] 연결 종료되었습니다...");
			} catch (IOException e) {}
		}
	}

}
