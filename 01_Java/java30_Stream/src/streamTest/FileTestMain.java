package streamTest;

import java.io.File;
import java.io.IOException;

//파일이나 디렉토리 정보 클래스

public class FileTestMain {
	public static void main(String[] args) {
		
		File f = new File("src/filse/asd.txt");
		if(!f.exists()) {//이 객체가 갖는 경로의 파일이 존재하면 true, 아니면 flase
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("파일경로 : "+f.getAbsolutePath());
		System.out.println("파일명 : "+f.getName());
		if(f.canRead()) {
			System.out.println("읽기 가능함");
		}
		if(f.canWrite()) {
			System.out.println("쓰기 가능함");
		}
		if(f.canExecute()) {
			System.out.println("실행 가능함");
		}
		f.delete();//파일 삭제
	}
}
