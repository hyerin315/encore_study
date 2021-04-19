package com.chatting.server;

import java.util.Vector;

public class Room {
	private Vector<ChatJob> members;
	
	public Room() {
		members = new Vector<>();
	}
	
	public void addMember(ChatJob c) {
		members.add(c);
	}
	
	public void delMember(ChatJob c) {
		members.remove(c);
	}
	
	public void sendMsgAll(String msg) {
		for(ChatJob c : members) {
			c.writeMsg(msg);
		}
	}
	
}
