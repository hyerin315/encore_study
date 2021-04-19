package com.chatting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		Room room = new Room();
		try {
			ServerSocket ss = new ServerSocket(5004);
			System.out.println("�系 ����ä�ù� ���� �����...");
			while (true) {
				Socket socket = ss.accept();// Ŭ���̾�Ʈ ���� ���
				System.out.println("==========���ӵ�===========");
				ChatJob cj = new ChatJob(socket, room);
				room.addMember(cj);
				cj.start();
			}
		} catch (IOException e) {
			System.out.println("!!!!!!���� �߻�!!!!!!!");
		}

	}

}
