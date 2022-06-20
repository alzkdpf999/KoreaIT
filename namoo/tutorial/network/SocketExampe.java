package namoo.tutorial.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Socket을 이용한 서버 연결 및 데이터 송수신 클라이언트
 * 
 * @author Administrator
 *
 */
public class SocketExampe {
	static final String IP = "127.0.0.1";
//	static final String IP = "192.168.7.101";
	static final int PORT = 2022;

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(IP, PORT);
			System.out.println("서버와 연결되었습니다..");

			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String message = null;
			Scanner scanner = new Scanner(System.in);
			while ((message = scanner.nextLine()) != null) {
				// 서버로 메시지 전송
				out.println(message);
				out.flush();

				if (message.equalsIgnoreCase("bye"))
					break;

				String serverMessage = in.readLine();
				System.out.println(serverMessage);
			}

//			out.close();
			socket.close();

		} catch (UnknownHostException e) {
			System.err.println("서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.err.println("네트워크 장애로 서버를 연결할 수 없습니다.");
		}

	}

}
