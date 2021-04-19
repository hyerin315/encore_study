package streamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest2Main {
	public static void main(String[] args) {
		try {
			//파일에 1바이트씩 출력하는 스트림
			//저장할 파일 경로 생성자에 지정
			//파일을 쓰기로 오픈할 때는 없으면 새로 생성하여 오픈
			FileOutputStream fo = new FileOutputStream("src/filse/b.txt");//쓰기 파일의 기본은 덮어쓰기, 이어쓰기 하려면 뒤에 true 추가
			int ch = ' ';
			while ((ch = System.in.read()) != '\n') {
				fo.write(ch);
				System.out.print((char)ch);
			}
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
