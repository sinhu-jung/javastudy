package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br= null;
		
		try {
			//1. 기반 스트림(표준 입력, stdin, System.in)
			
			//2. 보조 스트림1 (byte|byte|byte -> char) 3바이트씩 읽어서 char 1개로 바꿈
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
			
			//3. 보조 스트림2 (char1|char2|char3|\n -> "char1char2char3") char를 읽다가 개행이 오면 스트링으로 만듬
			br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					return;
				}
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
