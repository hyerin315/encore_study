package streamTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcessTest {
	public static void main(String[] args) {
		
		try {
			RandomAccessFile rf = new RandomAccessFile("src/filse/a.txt", "r");
			rf.seek(13);
			int ch = rf.read();
			System.out.println((char)ch);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
