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
			DatagramSocket socket = new DatagramSocket();//UDP 통신 소켓 생성
			byte[] buf = "hello".getBytes();//{'h', 'l', ...} 각 문자 하나하나를 바이트 배열로 변환 
			InetAddress addr = InetAddress.getByName("localhost");//ip를 IneAddress 타입으로 변환
			
			//패킷생성, 메세지 전송할 상대방의 주소, 포트 지정
			DatagramPacket packet = new DatagramPacket(buf, buf.length, addr, 4444);
			
			socket.send(packet);//메세지 전송

			//받은 패킷 저장할 새 패킷 생성
			packet = new DatagramPacket(buf, buf.length);
			
			//서버로부터 패킷 받음
			socket.receive(packet);
			
			//패킷 데이터를 추출해서 문자열 변환
			String str = new String(packet.getData(), 0, packet.getLength());
			System.out.println("서버 메세지 : " + str);//출력
			socket.close();//소켓 닫음
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
