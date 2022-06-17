
package namoo.tutorial.network.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 채팅 클라이언트의 요청에 대한 다양한 서비스제공
 * @author 정충효
 *
 */
public class ChatService {
	
	public  static final int PORT = 2022;
	private ServerSocket serversocket;
	//살아있는지 죽어있는지
	private boolean running;
	private List<ChatThread> clients; //고객을 하나하나 저장시키는
	public ChatService(int size) {
		clients = new ArrayList<ChatThread>(size);
		
	}

	public ServerSocket getServersocket() {
		return serversocket;
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
	public void startUp() throws IOException{
		this.serversocket= new ServerSocket(PORT);
		running = true;
	}
	/**
	 * 접속 클라이언트 연결 수신
	 * @throws IOException 
	 */
	public void connectListening()  {
		while(running) {
			Socket socket= null;
			try {
				socket = serversocket.accept();
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트가["+clientIP+"] 접속해왔습니다.");
				
				//스레드 생성 및 시작 관리도 여기서  
				ChatThread chatthread = new ChatThread(socket,this); //this 객체 자신
				clients.add(chatthread);
				chatthread.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	/**
	 * 서비스 종료
	 * @throws IOException 
	 */
	public void shutDown() throws IOException {
		running = false;
		serversocket.close();
	}
	/**
	 * 모든 접속한 클라이언트에게 메시지 전송
	 */
	public void sendAllMessage(String message) {
		for(ChatThread chatThread : clients) {
			chatThread.sendMessage(message);
		}
	}
}
