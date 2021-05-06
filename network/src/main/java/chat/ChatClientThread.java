package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while (true) {
				String data = br.readLine();
				if("quit".equals(data) == true) {
					break;
				}
				
				System.out.println(data);
				System.out.print(">>");
			}
		} catch (SocketException e) {
			ChatClient.log("채팅 종료");
		} catch (IOException e) {
			ChatClient.log("error:" + e);
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
