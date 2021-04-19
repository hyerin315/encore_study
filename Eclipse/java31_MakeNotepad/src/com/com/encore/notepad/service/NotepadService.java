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

/*메모장 클래스 
 * 기능 -> 1. 디렉토리 확인. 없으면 생성. 
 *		  2. 읽기 : 디렉토리 내 파일 목록 보여주기
 *                 사용자가 읽고 싶은 파일 선택하게 하기
 *                 그 파일 오픈해서 출력 
 *        3. 쓰기 : 파일명 입력 있으면 있다 없으면 없다 알려주기 // 중복이 되면 1.새이름 입력 2.이어쓰기 선택하게끔 
 *                 파일내용 키보드로 입력받기 /stop 입력 받을 때 까지 
 */
public class NotepadService {
	
	Notepad notepad;
	
	File checkfile;
	File checkPath;
	
	public NotepadService(Notepad notepad) {
		
		this.notepad = notepad;

	}
	
	
	/*읽기*/
	/*디렉토리 확인 : 없으면 생성 : 승연님*/
	public boolean checkDir() {
		
		File dir = new File(notepad.getDirPath());
		
		if(!dir.exists()) {
			dir.mkdir();
			System.out.println(notepad.getDirPath() +" 의 경로가 생성되었습니다. 확인해주세요.");
		}else {
			System.out.println("이미 해당 Directory 가 존재합니다.");
		}
		
		return false;
	}
	
	/*파일이 있는지 없는지 확인 : 해영님*/
	public boolean checkFile() {
		
		checkfile = new File(this.notepad.getDirPath() + "/" + this.notepad.getFileName());
	 
		try {
			
			if (checkfile.createNewFile()) {
				// System.out.println("파일이 생성되었습니다.");
				return false;
			} 
			else {
				// System.out.println("해당 파일이 존재합니다.");
				return true;
			}
			
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	/*전체 파일 목록 가지고 오기 : 동관님 */
	public File[] printFileList() {
		
		File path = new File(notepad.getDirPath()); //memo Folder를 따로 만들어서 주소를 넣었습니다. 합본 할 떄는 각자 저장하신 주소로 바꾸시면 됩니다.
		File[] fileList = path.listFiles();
		
		if(fileList.length>0) {
			for(int i = 0; i < fileList.length; i++){
				System.out.println(fileList[i]);
			}
		}
		return fileList;
	}
	
	/*선택된 파일 내용 console 출력 : 찬식*/
	public void printContentFile(String filePath, String fileName) {
		
		try {
			
			FileReader fileReader = new FileReader(filePath +"/"+fileName);
			BufferedReader br = new BufferedReader(fileReader);
			char[] buf = new char[1000];
			
			if(!fileReader.ready()) {
				System.out.println("입력한 파일 명을 다시 한 번 확인해주세요.");
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
			System.out.println("오류 발생 : 파일을 찾을 수 없습니다.");
			fn.printStackTrace();
		}catch(IOException io) {
			System.out.println("오류 발생 : 파일을 읽을 수 없습니다.");
			io.printStackTrace();
		}
	}
	
	/*파일에다가 쓰기 : 혜린님*/
	public void makeFileWrite(String fileName) {
		
		try {
			//FileOutputStream fo = new FileOutputStream(notepad.getDirPath() + "/" + fileName );
			FileWriter fw = new FileWriter(notepad.getDirPath() + "/" + notepad.getFileName());
			Scanner sc = new Scanner(System.in);
			
			/*FileOutputStream fi = new FileOutputStream(notepad.getDirPath());
			DataOutputStream df = new DataOutputStream(fi);*/
			
			//특정 문자를 받았을 때
			/*int ch = ' ';
			while ((ch=System.in.read())!= '/') {
				fo.write(ch);
			}*/
			
			//특정 문자열을 받았을 때
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
	
	
	
	/*여러 파일 압축 */ //소정
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
				System.out.println("압축 완료");
			}
			zo.close();
			fo.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*파일 삭제*/ //소정
	public void deleteFile(String name) {
		File f = new File(this.notepad.getDirPath() + "/" +name);
		
		if(f.exists()) {
			if(f.getName().equals(name)) {
				f.delete();
				System.out.println(name + " 이라는 파일 삭제 완료.");
			}
		}else {
			System.out.println("입력한 파일이 존재하지않아 삭제할 수 없습니다.");
		}
		
	
	}
	
	

}
