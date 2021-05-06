package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = ChatServer.PORT;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. 소켓 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			// 4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			// 5. join 프로토콜 
			System.out.print("닉네임>>");
			String nickName = scanner.nextLine();
			pw.println("JOIN:" + nickName);
			pw.flush();
			String ack = br.readLine();
			if("JOIN:OK".equals(ack)) {
				System.out.println("채팅 방에 입장하였습니다.");
			}
			
			// 6. ChatClientThread 시작 
			new ChatClientThread(socket).start();
			
			// 7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					//8. quit 프로토콜 처리
					pw.println("QUIT");
					break;
				} else {
					// 9. 메시지 처리
					pw.println("MESSAGE:" + input);
				}
			}
			
		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static void log(String log) {
		System.out.println("[ChatClient] " + log);
	}

}
