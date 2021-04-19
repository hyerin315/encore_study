package streamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//직렬화 : 

class Member implements Serializable{//ObjectOutputStream, ObjectInputStream의 대상 객체는 직렬화 처리 해야함 == 상속만 받으면 자동 구현
	String id;
	String pwd;
	String name;
	public Member() {
	}
	public Member(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
}


public class ObjectStreamTest {
	public static void main(String[] args) {
		Member m1 = new Member("aaa", "111", "namea");
		Member m2 = new Member("bbb", "222", "nameb");
		
		try {
			FileOutputStream fo = new FileOutputStream("src/filse/e.dat");//바이너라 타입의 파일 - 기계가 읽는 파일(사람이 못읽음)
			ObjectOutputStream oo = new ObjectOutputStream(fo);//객체 단위로 쓰는 ObjectOutputStream 객체 생성
			oo.writeObject(m1);
			oo.writeObject(m2);
			oo.close();
			fo.close();
			
			FileInputStream fi = new FileInputStream("src/filse/e.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);//객체 단위로 읽는 ObjectInputStream 객체 생성
			Member m3 = (Member) oi.readObject();//겍체 하나를 읽어서 Object 타입으로 반환
			Member m4 = (Member) oi.readObject();
			System.out.println(m3);
			System.out.println(m4);
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
