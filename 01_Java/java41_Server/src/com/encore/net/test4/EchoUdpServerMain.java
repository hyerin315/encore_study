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
			DatagramSocket socket = new DatagramSocket(4444);//udp 소켓, 서버 ip - localhost, port - 4444
			System.out.println("서버 시작");
			byte[] buf = new byte[256];
			
			//DatagramPacket : UDP 통신에서 사용하는 패킷
			//param1 : 저장할 버퍼, 데이터 크기
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			//패킷 받음. packet에 저장
			socket.receive(packet);
			
			//packet.getData() : 패킷에 저장된 데이터 추출 -> 문자열로 변환
			String str = new String(packet.getData(), 0, packet.getLength());//클라이언트한테 받은 메세지 출력
			System.out.println("클라이언트 메세지 : " + str);
			
			//아까와 달리 패킷에는 목적지 주소와 보낸사람 주소 있음 
			//packet.getAddress() : 보낸 컴퓨터 주소 추출
			InetAddress addr = packet.getAddress();
			
			//packet.getAddress() : 보낸 컴퓨터 포트번호 추출 
			int port = packet.getPort();
			
			//클라이언트에게 보낼 패킷 생성, param1:전송할 데이터, param2:데이터 크기, param3:목적지 주소, param4:목적지 포트 번호
			packet = new DatagramPacket(buf, buf.length, addr, port);
			
			//패킷 전송
			socket.send(packet);
			
			//다 전송하고 패킷 닫아주기
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
	}
		
		
	}

}
