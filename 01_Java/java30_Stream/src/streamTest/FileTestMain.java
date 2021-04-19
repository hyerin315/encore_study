package streamTest;

import java.io.File;
import java.io.IOException;

//�����̳� ���丮 ���� Ŭ����

public class FileTestMain {
	public static void main(String[] args) {
		
		File f = new File("src/filse/asd.txt");
		if(!f.exists()) {//�� ��ü�� ���� ����� ������ �����ϸ� true, �ƴϸ� flase
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("���ϰ�� : "+f.getAbsolutePath());
		System.out.println("���ϸ� : "+f.getName());
		if(f.canRead()) {
			System.out.println("�б� ������");
		}
		if(f.canWrite()) {
			System.out.println("���� ������");
		}
		if(f.canExecute()) {
			System.out.println("���� ������");
		}
		f.delete();//���� ����
	}
}
