package streamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest1Main {
	public static void main(String[] args) {
		try {
			// 파일에서 바이트 단위로 읽는 스트림
			FileInputStream fi = new FileInputStream("src/filse/a.txt");
			int ch;
			while ((ch = fi.read()) != -1) {//-1: end of file
				System.out.print((char) ch);
			}
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
