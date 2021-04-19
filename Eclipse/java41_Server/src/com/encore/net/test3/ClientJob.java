package com.encore.net.test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientJob extends Thread {//Ŭ���̾�Ʈ 1�� ��� ������
	private Socket socket;//Ŭ���̾�Ʈ�� ����� ����
	private PrintWriter out;
	private BufferedReader in;
	private String id;//Ŭ���̾�Ʈ ���̵� �о �Ҵ�
	private Room room;//ä�ù� ��ü

	public ClientJob(Socket socket, Room room) {
		this.socket = socket;//������ �޾ƿͼ� �а� �� �� �ִ� ��Ʈ�� ����
		this.room = room;
		
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			id = in.readLine();//Ŭ���̾�Ʈ ���̵� �޾Ƽ� ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public void run() {
    	String str = "", msg = "";
    	while(true) {
    		try {
    			str = in.readLine();//��� Ŭ���̾�Ʈ�� ���� �޼��� ����
    			msg = id+" : "+str;//�޼����� ���̵� �ٿ��� 
    			if(str.startsWith("/stop")) {//����� Ŭ���̾�Ʈ�� ��ž�̶�� �ϸ� break;
    				break;
    			}
    			room.sendMsgAll(msg);//�ϼ��� �޼����� ä�ù��� sendMsgAll()�� ��� Ŭ���̾�Ʈ���� ����
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	writeMsg(str);//��� Ŭ���̾�Ʈ ���α׷��� ���� �б� ������ ���Ḧ ���� ����
		room.delMember(this);//ä�ù濡�� ��
		room.sendMsgAll(id + "���� �����̽��ϴ�.");//���� Ŭ���̾�Ʈ�� ���� Ŭ���̾�Ʈ�� ���� �޼��� ����
    }
	
    public void writeMsg(String msg) {//��� Ŭ���̾�Ʈ 1���� �޼��� ����
    	out.println(msg);
		out.flush();
    }
}
