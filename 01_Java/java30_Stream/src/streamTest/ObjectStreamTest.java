package streamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//����ȭ : 

class Member implements Serializable{//ObjectOutputStream, ObjectInputStream�� ��� ��ü�� ����ȭ ó�� �ؾ��� == ��Ӹ� ������ �ڵ� ����
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
			FileOutputStream fo = new FileOutputStream("src/filse/e.dat");//���̳ʶ� Ÿ���� ���� - ��谡 �д� ����(����� ������)
			ObjectOutputStream oo = new ObjectOutputStream(fo);//��ü ������ ���� ObjectOutputStream ��ü ����
			oo.writeObject(m1);
			oo.writeObject(m2);
			oo.close();
			fo.close();
			
			FileInputStream fi = new FileInputStream("src/filse/e.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);//��ü ������ �д� ObjectInputStream ��ü ����
			Member m3 = (Member) oi.readObject();//��ü �ϳ��� �о Object Ÿ������ ��ȯ
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
