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
			Socket socket = new Socket("192.168.0.18", 3333);////���� IP, ��Ʈ ��ȣ  - ������ ���� ��û
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			out.println("hello");
			out.flush();
			String str = in.readLine();
			System.out.println("���� �޼��� :"+str);
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
