package com.encore.net.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//socket으로 서버 연결
//id 입력 받아 서버로 보냄

class ChatClient extends Thread{//서버가 보내준 메세지를 받아서 출력
	private BufferedReader in;
	private Socket socket;

	public ChatClient(Socket socket, BufferedReader in) {
		this.in = in;
		this.socket = socket;
	}

	@Override
	public void run() {
		String str = "";
		while (true) {
			try {
				str = in.readLine();
				if (str.startsWith("/stop")) {
					break;
				}
				System.out.println(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println("서버 읽기 쓰레드 종료");
			socket.close();//마지막으로 처리되는 곳에서 소켓을 닫아줘야함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


public class ChatClientMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Socket socket = new Socket("192.168.0.18", 3333);;//서버에 연결 요청
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.print("사용할 id:");
			String id = sc.next();
			out.println(id);
			out.flush();
			ChatClient cc = new ChatClient(socket, in);
			cc.start();
			
			while (true) {
				String str = "";
				str = sc.nextLine();// 메시지 입력
				out.println(str);// 메시지 서버 전송
				out.flush();
				if (str.startsWith("/stop")) {
					break;
				}
			}
			System.out.println("키보드 입력 쓰레드 종료");
		} catch (IOException e) {
			e.printStackTrace();
		} //서버ip, 포트
	}

}
