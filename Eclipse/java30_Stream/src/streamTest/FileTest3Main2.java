package streamTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest3Main2 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/streamTest/files/b.txt");
			BufferedReader br = new BufferedReader(fr);//¹öÆÛ ÀåÂø
			FileWriter fw = new FileWriter("src/streamTest/files/c.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			char[] buf = new char[50];
			
			while(br.read(buf)!=-1) {
				bw.write(buf);
			}
			br.close();
			bw.close();
			fr.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

