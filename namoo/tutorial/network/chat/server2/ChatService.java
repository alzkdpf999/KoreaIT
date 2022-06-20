package namoo.tutorial.network.chat.server2;
/**
 * 채팅 클라이언트의 요청에 대한 다양한 서비스 제공
 * @author 김기정
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatService {
	
	public static final int PORT = 2022;
	private ServerSocket serverSocket;
	private boolean running;
	private List<ChatThread> clients;
	
	public ChatService(int size) throws IOException {
		clients = new ArrayList<ChatThread>(size);
//		List에 대한 스레드 동기화 처리
		Collections.synchronizedList(clients);
	}
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	

	public List<ChatThread> getClients() {
		return clients;
	}
	/**
	 * 서비스 시작
	 * @throws IOException 
	 */
	public void startUp() throws IOException {
		serverSocket = new ServerSocket(PORT);
		running = true;
	}
	
	/**
	 * 접속 클라이언트 연결 수신
	 */
	public void connectListening() {
		while (running) {
			// 클라이언트가 접속해 올때까지 블락메소드
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.println("클라이넌트["+clientIP+"]가 접속해왔습니다..");
				
				// 스레드 생성 및 시작
				ChatThread chatThread = new ChatThread(socket, this);
//				 접속 클라이언트 리스트에 등록
//				clients.add(chatThread);
				addClient(chatThread);
				chatThread.start();
				System.out.println("접속한 클라이언트 개수: " + clients.size());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 접속한 모든 클라이언트에게 메시지 전송
	 */
	public void sendAllMessage(String message) {
		for (ChatThread chatThread : clients) {
			 chatThread.sendMessage(message);
		}
	}
	
	/*
	 * 접속 클라이언트 리스트에 등록
	 */
	public void addClient(ChatThread chatThread) {
		clients.add(chatThread);
	}
	
	/** 연결 해제 클라이언트 제거 */
	public void removeClient(ChatThread chatThread){
		clients.remove(chatThread);
	}
	
	/**
	 * 서비스 종료
	 * @throws IOException 
	 */
	public void shutDown() throws IOException {
		serverSocket.close();
	}
}






