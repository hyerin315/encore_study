package com.encore.net.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientJob extends Thread {//클라이언트 1명 담당 쓰레드
	private Socket socket;//클라이언트와 연결된 소켓
	private PrintWriter out;
	private BufferedReader in;
	private String id;//클라이언트 아이디 읽어서 할당
	private Room room;//채팅방 객체

	public ClientJob(Socket socket, Room room) {
		this.socket = socket;//소켓을 받아와서 읽고 쓸 수 있는 스트림 생성
		this.room = room;
		
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			id = in.readLine();//클라이언트 아이디 받아서 전송
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public void run() {
    	String str = "", msg = "";
    	while(true) {
    		try {
    			str = in.readLine();//담당 클라이언트가 보낸 메세지 읽음
    			msg = id+" : "+str;//메세지에 아이디 붙여줌 
    			if(str.startsWith("/stop")) {//담당한 클라이언트가 스탑이라고 하면 break;
    				break;
    			}
    			room.sendMsgAll(msg);//완성된 메세지를 채팅방의 sendMsgAll()로 모든 클라이언트에게 전달
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	writeMsg(str);//담당 클라이언트 프로그램의 서버 읽기 쓰레드 종료를 위해 보냄
		room.delMember(this);//채팅방에서 뺌
		room.sendMsgAll(id + "님이 나가셨습니다.");//남은 클라이언트에 현재 클라이언트가 나간 메세지 전송
    }
	
    public void writeMsg(String msg) {//담당 클라이언트 1명에게 메세지 전송
    	out.println(msg);
		out.flush();
    }
}
