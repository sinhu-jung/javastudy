package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress(); 			
			System.out.println(hostname);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				//System.out.print(address);
				//System.out.println((int)address); // 형변환을 하게 되면 msb도 같이 올라감
				System.out.print(address & 0x000000ff);
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
