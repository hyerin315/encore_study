package com.encore.notepad.test;

import java.io.File;
import java.util.Scanner;

import com.encore.notepad.Notepad;
import com.encore.notepad.service.NotepadService;

public class NotepadTest {

	public static void main(String[] args) {
		
		String filePath = "";
		String fileName = "";
		int num = 0;
		
		Scanner sc = new Scanner(System.in);
		
		/*���丮 �Է�*/
		System.out.println("=====Input Path : ");
		
		/*�⺻��� ->>>*/   //"src/com/encore/notepad/memo";
		filePath = sc.nextLine();
		
		/*���� �̸� �Է�*/
		System.out.println("=====Input filename : ");
		fileName = sc.nextLine();
		
		NotepadService service = new NotepadService(new Notepad(filePath, fileName));
		
		/*���� �б�*/
		// ��� -> 1. ���丮 Ȯ��. ������ ����. 
		//		  2. �б� : ���丮 �� ���� ��� �����ֱ�
		//                 ����ڰ� �а� ���� ���� �����ϰ� �ϱ�
		//                 �� ���� �����ؼ� ��� 
		
		
		//���丮 Ȯ�� �� ���� 
		System.out.println("=====���丮�� Ȯ���մϴ�=====");
		service.checkDir();
		System.out.println();
		
		//������ �ִ��� ������ Ȯ�� 
		System.out.println("=====������ Ȯ���մϴ�=====");
		if(service.checkFile()) {
			System.out.println("�ش� ������ �����մϴ�.");
		}else {
			System.out.println("������ �����Ǿ����ϴ�.");
		}
		System.out.println();
		
		
		//��ü ���� ��� ������ ���� 
		System.out.println("=====��� ������ ����մϴ�.=====");
		/*File[] arr = service.printFileList();
		
		for (File p : arr) {
			System.out.println(p);
		}*/
		service.printFileList();
		System.out.println();
		
		//���õ� ���ϳ��� console�� ��� 
	
		/*���� �̸� �Է�*/
		System.out.println("=====�о���� ���� ���� �Է����ּ���.=====");
		fileName = "";
		fileName = sc.nextLine();
		System.out.println(fileName + "�� �����ϼ̽��ϴ�. ������ �ִ��� Ȯ���ϰڽ��ϴ�.");
		if(service.checkFile()) {
			System.out.println("�ش� ������ �����մϴ�.");
		}else {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
		System.out.println();
		service.printContentFile(filePath, fileName);
		
		
		/*���� ����*/
		//*        3. ���� : ���ϸ� �Է� -> ������ �ִ� ������ ���� �˷��ֱ� // �ߺ��� �Ǹ� 1.���̸� �Է� 2.�̾�� �����ϰԲ� 
		//*                 ���ϳ��� Ű����� �Է¹ޱ� /stop �Է� ���� �� ���� 
		
		
		//���Ͽ��ٰ� ���� 
		System.out.println("=====���� ���Ⱑ ���۵˴ϴ�.=====");
		System.out.println("���� �Է�(/stop �Է½� ����) : ");
		service.makeFileWrite(fileName);
		System.out.println();
		
		System.out.println("=====�Էµ� ������ ����մϴ�..=====");
		service.printContentFile(filePath, fileName);
		System.out.println();
	    //�����ϰ� �����ϱ�
			
		//view files
		System.out.println("=====���� ���� �ִ� ��� ���� ����� ����մϴ�.=====");
		service.printFileList();
		System.out.println("=====�����ϰ� �����ϰ� �����ϴ� �޴��Դϴ�.=====");
		//zip files
		System.out.println("zip�Ϸ��� ���� ����(���鱸��):");
		//num = sc.nextInt();
		num = 2;
		System.out.println("������ zip���� �̸�:");
		//String zipFileName = sc.next();
		String zipFileName = "new";
		System.out.println("zip�Ϸ��� �����̸��� �ϳ��� �Է��ϼ���: ");
		String[] paths = new String[num];
		
/*		for(int i=0; i<num; i++) {
			String input = sc.next();
			//paths[i] = "src/com/encore/notepad/memo/"+input;
			paths[i] = filePath +input;
		}*/
		
		paths[0] = "src\\com\\encore\\notepad\\memo\\StringOutput2.txt";
		paths[1] = "src\\com\\encore\\notepad\\memo\\output2.txt";
		
		
		service.zipFiles(paths, zipFileName);
		
		//delete file
		System.out.println("������ ���� �̸��� �Է����ּ���:");
		//fileName=sc.next();
		fileName = "a.txt";
		service.deleteFile(fileName);


		sc.close();
	}

}
