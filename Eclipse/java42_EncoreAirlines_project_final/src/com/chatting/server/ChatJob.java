package com.chatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatJob extends Thread{
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private String id;
	private Room room;

	public ChatJob(Socket socket, Room room) {
		this.socket = socket;
		this.room = room;
		
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			id = in.readLine();
			System.out.println(id + "님이 접속하셨습니다.");
		} catch (IOException e) {
			System.out.println("!!!!!!접속 오류 발생!!!!!!!");
		}
	}
	
    public void run() {
    	String str = "", msg = "";
    	while(true) {
    		try {
    			str = in.readLine();
    			msg = id+" : "+str;
    			if(str.startsWith("나가기")) {
    				break;
    			}
    			room.sendMsgAll(msg);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	writeMsg(str);
		room.delMember(this);
		room.sendMsgAll(id + "님이 나가셨습니다.");
    }
	
    public void writeMsg(String msg) {
    	out.println(msg);
		out.flush();
    }
}
