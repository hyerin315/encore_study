package com.encore.notepad;
       
/*메모장 클래스 
 * 기능 -> 1. 디렉토리 확인. 없으면 생성. 
 *		  2. 읽기 : 디렉토리 내 파일 목록 보여주기
 *                 사용자가 읽고 싶은 파일 선택하게 하기
 *                 그 파일 오픈해서 출력 
 *        3. 쓰기 : 파일명 입력 있으면 있다 없으면 없다 알려주기 // 중복이 되면 1.새이름 입력 2.이어쓰기 선택하게끔 
 *                 파일내용 키보드로 입력받기 /stop 입력 받을 때 까지 
 */
public class Notepad {
	
	/*맴버변수*/
	private String dirPath;//경로 
	private String fileName;//파일 명
	private String content;//내용
	
	public Notepad(String dirPath, String fileName) {
		this.dirPath = dirPath;
		this.fileName = fileName;
		this.content = "";
	}
//getter
	public String getDirPath() {
		return dirPath;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getContent() {
		return content;
	}
//setter
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
