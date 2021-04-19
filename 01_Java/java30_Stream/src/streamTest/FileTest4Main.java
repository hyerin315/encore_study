package streamTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTest4Main {
	public static void main(String[] args) {
		int ch;
		InputStreamReader ir = new InputStreamReader(System.in);//바이트단위로 읽은 데이터를 문자로 변환
		BufferedReader br = new BufferedReader(ir);//스트림에 버퍼 장착
		try {
			while ((ch = br.read()) != '\n') {
				System.out.print((char) ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}