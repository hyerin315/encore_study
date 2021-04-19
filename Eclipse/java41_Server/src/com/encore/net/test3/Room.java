package com.encore.net.test3;

import java.util.Vector;

public class Room {//ä�� �� Ŭ����
	private Vector<ClientJob> members;//Ŭ���̾�Ʈ ����� ������ ��ü���� ���� ����Ʈ
	
	public Room() {
		members = new Vector<>();
	}
	
	public void addMember(ClientJob c) {
		members.add(c);
	}
	
	public void delMember(ClientJob c) {
		members.remove(c);
	}
	
	public void sendMsgAll(String msg) {//ä�ù濡 ��� Ŭ���̾�Ʈ�� �޼��� ����
		for(ClientJob c : members) {
			c.writeMsg(msg);//�����尡 ����ϴ� Ŭ���̾�Ʈ 1���Ը� �޼��� ����
		}
	}
	
}