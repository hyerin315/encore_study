package streamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest2Main {
	public static void main(String[] args) {
		try {
			//���Ͽ� 1����Ʈ�� ����ϴ� ��Ʈ��
			//������ ���� ��� �����ڿ� ����
			//������ ����� ������ ���� ������ ���� �����Ͽ� ����
			FileOutputStream fo = new FileOutputStream("src/filse/b.txt");//���� ������ �⺻�� �����, �̾�� �Ϸ��� �ڿ� true �߰�
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
