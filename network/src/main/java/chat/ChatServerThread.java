package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickName;
	private Socket socket;
	private List<PrintWriter> listPrintWriter;

	public ChatServerThread(Socket socket, List<PrintWriter> listPrintWriter) {
		this.socket = socket;
		this.listPrintWriter = listPrintWriter;
	}

	@Override
	public void run() {
		// 1. Remote Host Information
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			// 2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 3. 요청 처리
			while (true) {
				String request = br.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					break;
				}

				String[] tokens = request.split(":");
				if ("JOIN".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("MESSAGE".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("QUIT".equals(tokens[0])) {
					doQuit(pw);
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}

			}

		} catch (SocketException e) {
			ChatServer.log("suddenly closed by client");
		} catch (IOException e) {
			ChatServer.log("error: " + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void doJoin(String nickName, PrintWriter printWriter) {
		this.nickName = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		/*Writer Pool에 저장*/
		addWriter(printWriter);
		
		// ack
		printWriter.println("JOIN:OK");
		printWriter.flush();
	}

	private void broadcast(String data) {
		synchronized(listPrintWriter) {
			for(Writer writer : listPrintWriter) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println( data );
				printWriter.flush();
			}
		}
	}

	private void addWriter(PrintWriter printWriter) {
		synchronized(listPrintWriter) {
			listPrintWriter.add(printWriter);
		}
	}

	private void doMessage(String message) {
		broadcast(this.nickName + ":" + message);
	}

	private void doQuit(PrintWriter printWriter) {
		removeWriter(printWriter);
		
		String data = nickName + "님이 퇴장 하였습니다.";
		broadcast(data);
		
	}

	private void removeWriter(PrintWriter printWriter) {
		synchronized(listPrintWriter) {
			listPrintWriter.remove(printWriter);
		}
	}
}
