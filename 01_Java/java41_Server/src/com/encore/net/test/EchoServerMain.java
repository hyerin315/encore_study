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
			ServerSocket ss = new ServerSocket(3333);//3333 : port 번호
			System.out.println("echo server start");
			Socket socket = ss.accept();//클라이언트 접속 대기 --> 클라이언트가 접속하길 계속 기다림
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());//소켓에 바이트단위로 쓰는 스트림 반환
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//소켓에 바이트 단위로 읽는 스트림 반환
			
			String str = in.readLine();//소켓에서 1줄 읽음 -> 메세지를 안쓰면 계속 기다림
			System.out.println("클라이언트 메세지 : "+str);
			out.println(str+"\n");
			out.flush();//버퍼의 내용을 강제 출력하고 비움 
			Thread.sleep(5000);
			ss.close();//더 이상 안받겠다
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
