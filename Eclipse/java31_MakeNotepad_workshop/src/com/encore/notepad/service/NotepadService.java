package com.encore.notepad.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.encore.notepad.Notepad;

/*�޸��� Ŭ���� 
 * ��� -> 1. ���丮 Ȯ��. ������ ����. 
 *		  2. �б� : ���丮 �� ���� ��� �����ֱ�
 *                 ����ڰ� �а� ���� ���� �����ϰ� �ϱ�
 *                 �� ���� �����ؼ� ��� 
 *        3. ���� : ���ϸ� �Է� ������ �ִ� ������ ���� �˷��ֱ� // �ߺ��� �Ǹ� 1.���̸� �Է� 2.�̾�� �����ϰԲ� 
 *                 ���ϳ��� Ű����� �Է¹ޱ� /stop �Է� ���� �� ���� 
 */
public class NotepadService {
	
	Notepad notepad;
	
	File checkfile;
	File checkPath;
	
	public NotepadService(Notepad notepad) {
		
		this.notepad = notepad;

	}
	
	
	/*�б�*/
	/*���丮 Ȯ�� : ������ ���� : �¿���*/
	public boolean checkDir() {
		
		File dir = new File(notepad.getDirPath());
		
		if(!dir.exists()) {
			dir.mkdir();
			System.out.println(notepad.getDirPath() +" �� ��ΰ� �����Ǿ����ϴ�. Ȯ�����ּ���.");
		}else {
			System.out.println("�̹� �ش� Directory �� �����մϴ�.");
		}
		
		return false;
	}
	
	/*������ �ִ��� ������ Ȯ�� : �ؿ���*/
	public boolean checkFile() {	
		checkfile = new File(this.notepad.getDirPath() + "/" + this.notepad.getFileName());
	 
		try {	
			if (checkfile.createNewFile()) {
				// System.out.println("������ �����Ǿ����ϴ�.");
				return false;
			} 
			else {
				// System.out.println("�ش� ������ �����մϴ�.");
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	/*��ü ���� ��� ������ ���� : ������ */
	public File[] printFileList() {
		
		File path = new File(notepad.getDirPath()); //memo Folder�� ���� ���� �ּҸ� �־����ϴ�. �պ� �� ���� ���� �����Ͻ� �ּҷ� �ٲٽø� �˴ϴ�.
		File[] fileList = path.listFiles();
		
		if(fileList.length>0) {
			for(int i = 0; i < fileList.length; i++){
				System.out.println(fileList[i]);
			}
		}
		return fileList;
	}
	
	/*���õ� ���� ���� console ��� : ����*/
	public void printContentFile(String filePath, String fileName) {
		
		try {
			
			FileReader fileReader = new FileReader(filePath +"/"+fileName);
			BufferedReader br = new BufferedReader(fileReader);
			char[] buf = new char[1000];
			
			if(!fileReader.ready()) {
				System.out.println("�Է��� ���� ���� �ٽ� �� �� Ȯ�����ּ���.");
				br.close();
				return;
			}
			
			while(br.read(buf) != -1) {
				System.out.println(buf);
			}
			
		/*	for(char a : buf)
				System.out.println(a);*/
			
			br.close();
			fileReader.close();
			
		}catch(FileNotFoundException fn) {
			System.out.println("���� �߻� : ������ ã�� �� �����ϴ�.");
			fn.printStackTrace();
		}catch(IOException io) {
			System.out.println("���� �߻� : ������ ���� �� �����ϴ�.");
			io.printStackTrace();
		}
	}
	
	/*���Ͽ��ٰ� ���� : ������*/
	public void makeFileWrite(String fileName) {
		
		try {
			//FileOutputStream fo = new FileOutputStream(notepad.getDirPath() + "/" + fileName );
			FileWriter fw = new FileWriter(notepad.getDirPath() + "/" + notepad.getFileName());
			Scanner sc = new Scanner(System.in);
			
			/*FileOutputStream fi = new FileOutputStream(notepad.getDirPath());
			DataOutputStream df = new DataOutputStream(fi);*/
			
			//Ư�� ���ڸ� �޾��� ��
			/*int ch = ' ';
			while ((ch=System.in.read())!= '/') {
				fo.write(ch);
			}*/
			
			//Ư�� ���ڿ��� �޾��� ��
			while(true) {
				String tempString = sc.nextLine();
				if(tempString.equals("/stop")) {
					break;
				}
				fw.write(tempString);
					
			}
			
			sc.close();
			fw.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*���� ���� ���� */ //����
	public void zipFiles(String[] pathsToZip, String zipFileName) {
		try {
			String zipName = zipFileName.concat(".zip");
			FileOutputStream fo = new FileOutputStream(zipName);
			ZipOutputStream zo = new ZipOutputStream(fo);
			
			for(String path: pathsToZip) {
				zo.putNextEntry(new ZipEntry(new File(path).getName()));
				byte[] bytes = Files.readAllBytes(Paths.get(path));
				zo.write(bytes,0,bytes.length);
				zo.closeEntry();
				System.out.println("���� �Ϸ�");
			}
			zo.close();
			fo.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*���� ����*/ //����
	public void deleteFile(String name) {
		File f = new File(this.notepad.getDirPath() + "/" +name);
		
		if(f.exists()) {
			if(f.getName().equals(name)) {
				f.delete();
				System.out.println(name + " �̶�� ���� ���� �Ϸ�.");
			}
		}else {
			System.out.println("�Է��� ������ ���������ʾ� ������ �� �����ϴ�.");
		}
		
	
	}
	
	

}
