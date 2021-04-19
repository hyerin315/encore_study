package com.chatting.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



class ChatEmployee extends Thread{
	private BufferedReader in;
	private Socket socket;

	public ChatEmployee(Socket socket, BufferedReader in) {
		this.in = in;
		this.socket = socket;
	}

	@Override
	public void run() {
		String str = "";
		while (true) {
			try {
				str = in.readLine();
				if (str.startsWith("Bye")) {
					break;
				}
				System.out.println(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


public class EmployeeMain {
	public void chatEmployeeMethod() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("============�系 ���� ä�ù��Դϴ�(�弳, ��� X)=============");
			Socket socket = new Socket("localhost", 5004);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.print("\n����� �г���:");
			String id = sc.nextLine();
			out.println(id);
			out.flush();
			ChatEmployee cc = new ChatEmployee(socket, in);
			cc.start();
			
			while (true) {
				String str = "";
				str = sc.nextLine();
				out.println(str);
				out.flush();
				if (str.startsWith("������")) {
					break;
				}
			}
			System.out.println("ä�� ����");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
