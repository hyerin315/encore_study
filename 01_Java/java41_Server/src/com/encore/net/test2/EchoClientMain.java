package com.encore.net.test2;

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
			Socket socket = new Socket("192.168.0.18", 3333);;//서버에 연결 요청
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String str = "";
				str = sc.next();;//메시지 입력
				out.println(str);//메시지 서버 전송
				out.flush();
				str = in.readLine();//서버 메아리 받음
				System.out.println("서버 메시지: " + str);
				if(str.startsWith("/stop")) {
					break;
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} //서버ip, 포트
	}

}
