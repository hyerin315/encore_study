package com.encore.net.test4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoUdpServerMain {

	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(4444);//udp ����, ���� ip - localhost, port - 4444
			System.out.println("���� ����");
			byte[] buf = new byte[256];
			
			//DatagramPacket : UDP ��ſ��� ����ϴ� ��Ŷ
			//param1 : ������ ����, ������ ũ��
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			//��Ŷ ����. packet�� ����
			socket.receive(packet);
			
			//packet.getData() : ��Ŷ�� ����� ������ ���� -> ���ڿ��� ��ȯ
			String str = new String(packet.getData(), 0, packet.getLength());//Ŭ���̾�Ʈ���� ���� �޼��� ���
			System.out.println("Ŭ���̾�Ʈ �޼��� : " + str);
			
			//�Ʊ�� �޸� ��Ŷ���� ������ �ּҿ� ������� �ּ� ���� 
			//packet.getAddress() : ���� ��ǻ�� �ּ� ����
			InetAddress addr = packet.getAddress();
			
			//packet.getAddress() : ���� ��ǻ�� ��Ʈ��ȣ ���� 
			int port = packet.getPort();
			
			//Ŭ���̾�Ʈ���� ���� ��Ŷ ����, param1:������ ������, param2:������ ũ��, param3:������ �ּ�, param4:������ ��Ʈ ��ȣ
			packet = new DatagramPacket(buf, buf.length, addr, port);
			
			//��Ŷ ����
			socket.send(packet);
			
			//�� �����ϰ� ��Ŷ �ݾ��ֱ�
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
	}
		
		
	}

}
