package namoo.tutorial.network.chat.client;

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
	private Scanner keyboard;
	
	public SenderThread(Socket socket) throws IOException {
		this.socket = socket;
		out = new PrintWriter(socket.getOutputStream());
	}

	public Socket getSocket() {
		return socket;
	}

	public PrintWriter getOut() {
		return out;
	}
	
	@Override
	/** 사용자 스레드의 엔트리 포인트 */
	public void run() {
		keyboard = new Scanner(System.in);
		String inputMessage = null;
		while ((inputMessage=keyboard.nextLine()) != null) {
			out.println(inputMessage);
			out.flush();
			if (inputMessage.equalsIgnoreCase("bye")) break;
		}
	}
}