package namoo.tutorial.network.chat.client2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NamooTalk {
	static final String IP = "127.0.0.1";
	static final int PORT = 2022;

	public static void main(String[] args) {
//		사용할 닉네임 입력
		System.out.print("사용할 닉네임 : ");
		Scanner scanner = new Scanner(System.in);
		String nickName =  scanner.nextLine();
		System.out.println(nickName);
		
		if(nickName == null || nickName.trim().length() == 0) return;
		
		try {
			Socket socket = new Socket(IP, PORT);
			System.out.println("Chat Server["+IP+":"+PORT+"] Connected...");
			System.out.println("=====" + nickName+"님 즐거운 대화나누세요 =====");
			
//			스레드 생성 및 시작
			SenderThread senderThread = new SenderThread(socket, nickName);
			ReceiverThread receiverThread =  new ReceiverThread(socket);
			senderThread.start();
			receiverThread.start();
			
		} catch (UnknownHostException e) {
			System.err.println("서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.err.println("네트워크 장애로 서버를 연결할 수 없습니다.");
		}
	}
}