package com.encore.net.test3;

import java.util.Vector;

public class Room {//채팅 방 클래스
	private Vector<ClientJob> members;//클라이언트 담당자 쓰레드 객체들을 담을 리스트
	
	public Room() {
		members = new Vector<>();
	}
	
	public void addMember(ClientJob c) {
		members.add(c);
	}
	
	public void delMember(ClientJob c) {
		members.remove(c);
	}
	
	public void sendMsgAll(String msg) {//채팅방에 모든 클라이언트에 메세지 전송
		for(ClientJob c : members) {
			c.writeMsg(msg);//쓰레드가 담당하는 클라이언트 1명에게만 메세지 전송
		}
	}
	
}