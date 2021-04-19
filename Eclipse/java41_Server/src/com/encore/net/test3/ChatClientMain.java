package com.encore.net.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//socket���� ���� ����
//id �Է� �޾� ������ ����

class ChatClient extends Thread{//������ ������ �޼����� �޾Ƽ� ���
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
			System.out.println("���� �б� ������ ����");
			socket.close();//���������� ó���Ǵ� ������ ������ �ݾ������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


public class ChatClientMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Socket socket = new Socket("192.168.0.18", 3333);;//������ ���� ��û
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.print("����� id:");
			String id = sc.next();
			out.println(id);
			out.flush();
			ChatClient cc = new ChatClient(socket, in);
			cc.start();
			
			while (true) {
				String str = "";
				str = sc.nextLine();// �޽��� �Է�
				out.println(str);// �޽��� ���� ����
				out.flush();
				if (str.startsWith("/stop")) {
					break;
				}
			}
			System.out.println("Ű���� �Է� ������ ����");
		} catch (IOException e) {
			e.printStackTrace();
		} //����ip, ��Ʈ
	}

}
