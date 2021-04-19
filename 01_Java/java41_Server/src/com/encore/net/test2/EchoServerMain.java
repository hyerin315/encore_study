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
				str = in.readLine();//�� �����尡 ����ϴ� Ŭ���̾�Ʈ 1���� ������ �޽��� ����
				System.out.println("Ŭ���̾�Ʈ �޽���: " + str);
				out.println(str);
				out.flush();//������ ������ ���� ����ϰ� ���
				if (str.startsWith("/stop")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}//���Ͽ��� 1�� ����
		}
	}
}

public class EchoServerMain {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(3333);// port:3333
			System.out.println("echo server start");
			while (true) {
				Socket socket = ss.accept();//Ŭ���̾�Ʈ ���� ���
				EchoServer es = new EchoServer(socket);
				es.start();
			}
			// ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
