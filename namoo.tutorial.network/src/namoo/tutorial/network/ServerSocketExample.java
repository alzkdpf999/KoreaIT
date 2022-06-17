package namoo.tutorial.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import namoo.tutorial.network.chat.server.ChatThread;

/*
 * 클라이언트의 연결을 수신하고, 특정 서비스를 제공하기 위해 
 * Serversocket을 생성한다.
 */
public class ServerSocketExample {
	static final int PORT = 2022; //1025이상으로만 사용 하길
	public static void main(String[] args) {
		try {
			ServerSocket server =new ServerSocket(PORT); // 소켓 생성 하는 
			System.out.println("서버가 정상 구동되었습니다. ");
			while(true) {
				Socket socket=server.accept();// 클라이언트 연결 받아들이기 리턴타입 Socket 연결이안되면 생성 안됨 
				//20번째 줄 클라이언트가 접속해 올때까지 블락되어 있다.(대기하고있다 생각)
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트가["+clientIP+"] 접속해왔습니다.");// 이 코드가 실행되면
				//				InputStream in= socket.getInputStream(); //데이터 받아오기 텔넷에서 쓴 것이 일로 들어옴
				//				OutputStream out=socket.getOutputStream(); //데이터 쓰기
				//여기서 스레드 생성 및 시작 하는 부분을 넣어야한다.
				
//				ChatThread chatthread = new ChatThread(socket); 어쩔수없이 오류이기 때문에 그냥 주석처리
//				chatthread.start(); //독립적으로 실행시키기 위한 메소드 
				
				
				PrintWriter out= new PrintWriter(socket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//클라이언트 전송 데이터 수신
				String data=null;
				while((data=in.readLine())!=null) {

					System.out.println("수신데이터 : " +	data);
					if(data.equalsIgnoreCase("bye")) {
						System.out.println("클라이언트["+clientIP+"]가 접속을 종료합니다.");
						break;
					}
					//클라이언트에게 메시지 에코(echo)
					out.println(data);
					out.flush();
				}
			
				socket.close(); //30~47 클래스를 새로 만든다.
				
			}
		} catch (IOException e) {
			System.err.println("포트("+ PORT +") 충돌로 서버를 구동할 수 없습니다."); //port 충돌문제가 유력

		}
	}

}
//Socket socket=server.accept();// 클라이언트 연결 받아들이기 리턴타입 Socket 연결이안되면 생성 안됨 //블락메소드
//System.out.println("클라이언트가 접속해왔습니다.");// 이 코드가 실행되면
//InputStream in= socket.getInputStream(); //데이터 받아오기 텔넷에서 쓴 것이 일로 들어옴
//OutputStream out=socket.getOutputStream(); //데이터 쓰기
//
////클라이언트 전송 데이터 수신 
//int data=in.read();
//
//System.out.println("수신데이터 : " +(char)data);
//out.write(data);//클라이언트에게 그대로 날아감
//이렇게 짜면 한번만 실행되고 끝남 그래서 while문을 통해야 함 
