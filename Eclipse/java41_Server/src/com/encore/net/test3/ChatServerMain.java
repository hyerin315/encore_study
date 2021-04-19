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
				Socket socket = ss.accept();// 클라이언트 접속 대기
				ClientJob cj = new ClientJob(socket, room);//클라이언트 담당 쓰레드 생성.
				room.addMember(cj);//채팅방에 추가
				cj.start();//쓰레드 시작
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}