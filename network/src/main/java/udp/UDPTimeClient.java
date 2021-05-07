package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UDPTimeClient {
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = UDPTimeServer.PORT;
	private static final int BUFFER_SIZE = UDPTimeServer.BUFFER_SIZE;

	public static void main(String[] args) {
	DatagramSocket socket = null;
	Scanner scanner = null;
	
	try {
		// 1. Scanner 생성
		scanner = new Scanner(System.in);

		// 2. 소켓 생성
		socket = new DatagramSocket();

		while (true) {
			// 5. 키보드 입력 받기
			System.out.println(">");
			String line = scanner.nextLine();

			if ("quit".equals(line)) {
				break;
			}

			// 전송
			String now = new SimpleDateFormat("yyyy-MM-dd hh mm ss").format(new Date());
			byte[] sendData = now.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, new InetSocketAddress(SERVER_IP, SERVER_PORT));
			socket.send(sendPacket);

			
			// 7. 데이터 읽기
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			socket.receive(receivePacket); // blocking
			byte[] receiveData = receivePacket.getData();
			int length = receivePacket.getLength();
			String message = new String(receiveData, 0, length, "utf-8");
			
			// 8. 콘솔 출력
			System.out.println("<" + message);


		}

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if (scanner != null) {
				scanner.close();
			}
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}

		} finally {

		}
	}
}
}