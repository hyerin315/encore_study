package com.encore.net.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class EchoServer extends Thread {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public EchoServer(Socket socket) {
		this.socket = socket;
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		String str;
		while (true) {
			try {
				str = in.readLine();//이 쓰레드가 담당하는 클라이언트 1명이 보내는 메시지 읽음
				System.out.println("클라이언트 메시지: " + str);
				out.println(str);
				out.flush();//버퍼의 내용을 강제 출력하고 비움
				if (str.startsWith("/stop")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}//소켓에서 1줄 읽음
		}
	}
}

public class EchoServerMain {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(3333);// port:3333
			System.out.println("echo server start");
			while (true) {
				Socket socket = ss.accept();//클라이언트 접속 대기
				EchoServer es = new EchoServer(socket);
				es.start();
			}
			// ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
