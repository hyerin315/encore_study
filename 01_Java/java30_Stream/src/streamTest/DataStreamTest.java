package streamTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//�� ����Ʈ�� �а� ���� ��Ʈ��
public class DataStreamTest {
	public static void main(String[] args) {
		try {
			FileOutputStream fo = new FileOutputStream("src/filse/d.dat");//�⺻ ��Ʈ��
			DataOutputStream df = new DataOutputStream(fo);//���� ��Ʈ��
			//������ Ÿ�Ժ��� �а� ���� ��Ʈ��
			df.writeByte(10);
			df.writeChar('v');
		    df.writeUTF("hello");
		    df.writeFloat(2.34f);
		    df.writeBoolean(true);
		
		    FileInputStream fi = new FileInputStream("src/filse/d.dat");
		    DataInputStream di = new DataInputStream(fi);
		    System.out.println(di.readByte());
		    System.out.println(di.readChar());
		    System.out.println(di.readUTF());
		    System.out.println(di.readFloat());
		    System.out.println(di.readBoolean());
		
     		di.close();
	     	fi.close();

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
