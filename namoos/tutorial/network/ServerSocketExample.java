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

/**
 * 클라이언트의 연결을 수신하고, 특정 서비스를 제공하기 위해 ServerSocket를 생성한다.
 *
 */
public class ServerSocketExample {
	static final int PORT = 2022;

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("서버가 정상 구동되었습니다..");

			while (true) {
				// 클라이언트가 접속해 올때까지 블락메소드
				Socket socket = serverSocket.accept();
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.println("클라이넌트["+clientIP+"]가 접속해왔습니다..");
				// 스레드 생성 및 시작
//				ChatThread chatThread = new ChatThread(socket, this);
//				chatThread.start();
			}

		} catch (IOException e) {
			System.err.println("포트(" + PORT + ")충돌로 서버를 구동할 수 없습니다..");
		}
	}

}
