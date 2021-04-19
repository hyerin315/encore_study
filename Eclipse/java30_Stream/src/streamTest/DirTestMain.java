package streamTest;

import java.io.File;
import java.io.IOException;

public class DirTestMain {
	public static void main(String[] args) {
		File dir = new File("src/files/testDir");
		if(!dir.exists()) {
			dir.mkdir();//���丮 ����
		}
		File f1 = new File("src/files/testDir/a.txt");
		if(!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			File dir2 = new File("scr/streamTest/files");
			String[] list = dir2.list();//���丮 ���� ��� ��ȯ
			for(String f : list) {
				System.out.println(f);
			}
		}
	}
}
