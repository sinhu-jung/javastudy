package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 7000;

	public static void main(String[] args) {
		List<PrintWriter> listPrintWirter = new ArrayList<PrintWriter>();
		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 1-1. Time-Wait 상태에서도 소켓에 포트 번호
			// 		할당이 가능하게 하기 위해서...
			serverSocket.setReuseAddress(true);

			// 2. 바인딩
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts... [port:" + PORT + "]");

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listPrintWirter).start();
			}

		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static void log(String log) {
		System.out.println("[ChatServer] " + log);
	}

}
