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
			Socket socket = new Socket("192.168.0.18", 3333);;//������ ���� ��û
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String str = "";
				str = sc.next();;//�޽��� �Է�
				out.println(str);//�޽��� ���� ����
				out.flush();
				str = in.readLine();//���� �޾Ƹ� ����
				System.out.println("���� �޽���: " + str);
				if(str.startsWith("/stop")) {
					break;
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} //����ip, ��Ʈ
	}

}
