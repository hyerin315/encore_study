package streamTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTest4Main {
	public static void main(String[] args) {
		int ch;
		InputStreamReader ir = new InputStreamReader(System.in);//����Ʈ������ ���� �����͸� ���ڷ� ��ȯ
		BufferedReader br = new BufferedReader(ir);//��Ʈ���� ���� ����
		try {
			while ((ch = br.read()) != '\n') {
				System.out.print((char) ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}