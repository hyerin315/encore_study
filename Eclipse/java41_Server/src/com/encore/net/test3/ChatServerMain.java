package com.encore.net.test3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerMain {
	public static void main(String[] args) {
		Room room = new Room();
		try {
			ServerSocket ss = new ServerSocket(3333);// port:3333
			System.out.println("chat server start");
			while (true) {
				Socket socket = ss.accept();// Ŭ���̾�Ʈ ���� ���
				ClientJob cj = new ClientJob(socket, room);//Ŭ���̾�Ʈ ��� ������ ����.
				room.addMember(cj);//ä�ù濡 �߰�
				cj.start();//������ ����
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}