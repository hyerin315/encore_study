package com.encore.net.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMain {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(3333);//3333 : port ��ȣ
			System.out.println("echo server start");
			Socket socket = ss.accept();//Ŭ���̾�Ʈ ���� ��� --> Ŭ���̾�Ʈ�� �����ϱ� ��� ��ٸ�
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());//���Ͽ� ����Ʈ������ ���� ��Ʈ�� ��ȯ
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//���Ͽ� ����Ʈ ������ �д� ��Ʈ�� ��ȯ
			
			String str = in.readLine();//���Ͽ��� 1�� ���� -> �޼����� �Ⱦ��� ��� ��ٸ�
			System.out.println("Ŭ���̾�Ʈ �޼��� : "+str);
			out.println(str+"\n");
			out.flush();//������ ������ ���� ����ϰ� ��� 
			Thread.sleep(5000);
			ss.close();//�� �̻� �ȹްڴ�
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
