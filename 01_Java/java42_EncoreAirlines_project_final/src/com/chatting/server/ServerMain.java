package com.chatting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		Room room = new Room();
		try {
			ServerSocket ss = new ServerSocket(5004);
			System.out.println("사내 오픈채팅방 접속 대기중...");
			while (true) {
				Socket socket = ss.accept();// 클라이언트 접속 대기
				System.out.println("==========접속됨===========");
				ChatJob cj = new ChatJob(socket, room);
				room.addMember(cj);
				cj.start();
			}
		} catch (IOException e) {
			System.out.println("!!!!!!오류 발생!!!!!!!");
		}

	}

}
