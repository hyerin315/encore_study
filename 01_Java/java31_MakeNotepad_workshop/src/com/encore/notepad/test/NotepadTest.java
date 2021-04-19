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
		
		/*디렉토리 입력*/
		System.out.println("=====Input Path : ");
		
		/*기본경로 ->>>*/   //"src/com/encore/notepad/memo";
		filePath = sc.nextLine();
		
		/*파일 이름 입력*/
		System.out.println("=====Input filename : ");
		fileName = sc.nextLine();
		
		NotepadService service = new NotepadService(new Notepad(filePath, fileName));
		
		/*파일 읽기*/
		// 기능 -> 1. 디렉토리 확인. 없으면 생성. 
		//		  2. 읽기 : 디렉토리 내 파일 목록 보여주기
		//                 사용자가 읽고 싶은 파일 선택하게 하기
		//                 그 파일 오픈해서 출력 
		
		
		//디렉토리 확인 및 생성 
		System.out.println("=====디렉토리를 확인합니다=====");
		service.checkDir();
		System.out.println();
		
		//파일이 있는지 없는지 확인 
		System.out.println("=====파일을 확인합니다=====");
		if(service.checkFile()) {
			System.out.println("해당 파일이 존재합니다.");
		}else {
			System.out.println("파일이 생성되었습니다.");
		}
		System.out.println();
		
		
		//전체 파일 목록 가지고 오기 
		System.out.println("=====모든 파일을 출력합니다.=====");
		/*File[] arr = service.printFileList();
		
		for (File p : arr) {
			System.out.println(p);
		}*/
		service.printFileList();
		System.out.println();
		
		//선택된 파일내용 console에 출력 
	
		/*파일 이름 입력*/
		System.out.println("=====읽어들일 파일 명을 입력해주세요.=====");
		fileName = "";
		fileName = sc.nextLine();
		System.out.println(fileName + "을 선택하셨습니다. 파일이 있는지 확인하겠습니다.");
		if(service.checkFile()) {
			System.out.println("해당 파일이 존재합니다.");
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		System.out.println();
		service.printContentFile(filePath, fileName);
		
		
		/*파일 쓰기*/
		//*        3. 쓰기 : 파일명 입력 -> 있으면 있다 없으면 없다 알려주기 // 중복이 되면 1.새이름 입력 2.이어쓰기 선택하게끔 
		//*                 파일내용 키보드로 입력받기 /stop 입력 받을 때 까지 
		
		
		//파일에다가 쓰기 
		System.out.println("=====파일 쓰기가 시작됩니다.=====");
		System.out.println("내용 입력(/stop 입력시 멈춤) : ");
		service.makeFileWrite(fileName);
		System.out.println();
		
		System.out.println("=====입력된 내용을 출력합니다..=====");
		service.printContentFile(filePath, fileName);
		System.out.println();
	    //복사하고 압축하기
			
		//view files
		System.out.println("=====폴더 내에 있는 모든 파일 목록을 출력합니다.=====");
		service.printFileList();
		System.out.println("=====복사하고 압축하고 삭제하는 메뉴입니다.=====");
		//zip files
		System.out.println("zip하려는 파일 갯수(공백구분):");
		//num = sc.nextInt();
		num = 2;
		System.out.println("생성할 zip파일 이름:");
		//String zipFileName = sc.next();
		String zipFileName = "new";
		System.out.println("zip하려는 파일이름을 하나씩 입력하세요: ");
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
		System.out.println("삭제할 파일 이름을 입력해주세요:");
		//fileName=sc.next();
		fileName = "a.txt";
		service.deleteFile(fileName);


		sc.close();
	}

}
