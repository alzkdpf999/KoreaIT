package namoo.tutorial.network.chat.server2;

import java.io.IOException;

/**
 * ChatServer Application 
 * @author 김기정
 */
public class NamooChat {
	
	public static void main(String[] args) {
		try {
			ChatService chatService = new ChatService(100);
			chatService.startUp();
			System.out.println("채팅서버가 정상 구동되었습니다..");
			chatService.connectListening();
		} catch (IOException e1) {
			System.err.println("포트(" + ChatService.PORT + ")충돌로 서버를 구동할 수 없습니다..");
		}
	}

}
