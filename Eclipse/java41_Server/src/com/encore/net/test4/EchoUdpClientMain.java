package com.encore.net.test4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoUdpClientMain {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();//UDP ��� ���� ����
			byte[] buf = "hello".getBytes();//{'h', 'l', ...} �� ���� �ϳ��ϳ��� ����Ʈ �迭�� ��ȯ 
			InetAddress addr = InetAddress.getByName("localhost");//ip�� IneAddress Ÿ������ ��ȯ
			
			//��Ŷ����, �޼��� ������ ������ �ּ�, ��Ʈ ����
			DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, 4444);
			
			socket.send(packet);//�޼��� ����

			//���� ��Ŷ ������ �� ��Ŷ ����
			packet = new DatagramPacket(buf, buf.length);
			
			//�����κ��� ��Ŷ ����
			socket.receive(packet);
			
			//��Ŷ �����͸� �����ؼ� ���ڿ� ��ȯ
			String str = new String(packet.getData(), 0, packet.getLength());
			System.out.println("���� �޼��� : " + str);//���
			socket.close();//���� ����
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
