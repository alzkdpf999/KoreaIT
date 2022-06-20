package namoo.tutorial.network.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Thread extends java.lang.Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	
	public Thread(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
	}


	@Override
	public void run() {

		try {
			String message =null;
			Scanner sc= new Scanner(System.in);
			while((message =sc.nextLine())!=null) {

				//서버로 메시지 전송
				out.println(message);
				out.flush();
				if(message.equalsIgnoreCase("bye")) //대소문자 구분없이 bye를 입력하면 루프문 빠져나오기
				{
					System.out.println("서버를 종료합니다.");
					break;
				}
				String data=in.readLine();
				System.out.println(data);

				//			out.close(); socket만 닫아도 괜찮음

			}
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
