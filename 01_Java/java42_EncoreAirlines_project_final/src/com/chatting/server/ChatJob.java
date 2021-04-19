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
			System.out.println(id + "���� �����ϼ̽��ϴ�.");
		} catch (IOException e) {
			System.out.println("!!!!!!���� ���� �߻�!!!!!!!");
		}
	}
	
    public void run() {
    	String str = "", msg = "";
    	while(true) {
    		try {
    			str = in.readLine();
    			msg = id+" : "+str;
    			if(str.startsWith("������")) {
    				break;
    			}
    			room.sendMsgAll(msg);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	writeMsg(str);
		room.delMember(this);
		room.sendMsgAll(id + "���� �����̽��ϴ�.");
    }
	
    public void writeMsg(String msg) {
    	out.println(msg);
		out.flush();
    }
}
