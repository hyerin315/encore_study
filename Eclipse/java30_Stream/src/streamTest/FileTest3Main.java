package streamTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest3Main {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/filse/b.txt");
			FileWriter fw = new FileWriter("src/filse/c.txt");
			char[] buf = new char[50];
			
			while (fr.read(buf)!=1) {
				fw.write(buf);
			}
			
			fr.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
