package streamTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//한 바이트씩 읽고 쓰는 스트림
public class DataStreamTest {
	public static void main(String[] args) {
		try {
			FileOutputStream fo = new FileOutputStream("src/filse/d.dat");//기본 스트림
			DataOutputStream df = new DataOutputStream(fo);//보조 스트림
			//데이터 타입별로 읽고 쓰는 스트림
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
