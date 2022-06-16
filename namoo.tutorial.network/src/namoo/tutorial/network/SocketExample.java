package namoo.tutorial.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * Socket 을 이용한 서버 연결 및 데이터 송수신 클라이언트
 */
public class SocketExample {
	static final String IP = "127.0.0.1"; //=localhost 저기 숫자는 가상 컴퓨터
	static final String IP2= "192.168.7.101";//선생님 ip
	static final int PORT = 2022; 
	public static void main(String[] args) {
		try {
			Socket socket=new Socket(IP2, PORT);
			System.out.println("서버와 연결 성공");


			//			OutputStream out=socket.getOutputStream();
			PrintWriter out= new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//			InputStream in=socket.getInputStream();
			String message =null;
			Scanner sc= new Scanner(System.in);
			while((message =sc.nextLine())!=null) {
				
				//서버로 메시지 전송
				out.println(message);
				out.flush();
				if(message.equalsIgnoreCase("bye")) //대소문자 구분없이 bye를 입력하면 루프문 빠져나오기
					{System.out.println("서버를 종료합니다.");
					break;}
				String data=in.readLine();
				System.out.println(data);
			
			//			out.close(); socket만 닫아도 괜찮음
			
			}
			socket.close();
	

		} catch (UnknownHostException e) {
			System.err.println("서버를 찾을 수 없습니다."); //서버를 못찾아서
		} catch (IOException e) {
			System.err.println("네트워크 장애로 서버를 연결할 수 없습니다.");
		}
	}

}
