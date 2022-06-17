package namoo.tutorial.network.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Chat Server Application
 * 
 * @author 정충효
 *
 */
public class namooChat {

	public static void main(String[] args) {
		ChatService chatService = new ChatService(100);
		try {
			chatService.startUp();
			System.out.println("채팅서버가 정상 구동되었습니다.");
			chatService.connectListening();
		} catch (IOException e) {
			System.err.println("포트(" + ChatService.PORT + ") 충돌로 서버를 구동할 수 없습니다."); // port 충돌문제가 유력
		}
	}
}

/* ServerSocket server =new ServerSocket(PORT); // 소켓 생성 하는
 * while(true) {
	Socket socket=server.accept();// 클라이언트 연결 받아들이기 리턴타입 Socket 연결이안되면 생성 안됨 
	//20번째 줄 클라이언트가 접속해 올때까지 블락되어 있다.(대기하고있다 생각)
	String clientIP = socket.getInetAddress().getHostAddress();
	System.out.println("클라이언트가["+clientIP+"] 접속해왔습니다.");// 이 코드가 실행되면
	//				InputStream in= socket.getInputStream(); //데이터 받아오기 텔넷에서 쓴 것이 일로 들어옴
	//				OutputStream out=socket.getOutputStream(); //데이터 쓰기

	//여기서 스레드 생성 및 시작 하는 부분을 넣어야한다.
	ChatThread chatthread = new ChatThread(socket);
	chatthread.start(); //독립적으로 실행시키기 위한 메소드 
}
*/