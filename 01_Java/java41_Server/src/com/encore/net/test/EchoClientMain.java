package com.encore.net.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Socket socket = new Socket("192.168.0.18", 3333);////서버 IP, 포트 번호  - 서버에 연결 요청
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			out.println("hello");
			out.flush();
			String str = in.readLine();
			System.out.println("서버 메세지 :"+str);
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
