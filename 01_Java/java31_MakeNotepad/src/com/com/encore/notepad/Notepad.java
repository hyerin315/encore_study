package com.encore.notepad;
       
/*�޸��� Ŭ���� 
 * ��� -> 1. ���丮 Ȯ��. ������ ����. 
 *		  2. �б� : ���丮 �� ���� ��� �����ֱ�
 *                 ����ڰ� �а� ���� ���� �����ϰ� �ϱ�
 *                 �� ���� �����ؼ� ��� 
 *        3. ���� : ���ϸ� �Է� ������ �ִ� ������ ���� �˷��ֱ� // �ߺ��� �Ǹ� 1.���̸� �Է� 2.�̾�� �����ϰԲ� 
 *                 ���ϳ��� Ű����� �Է¹ޱ� /stop �Է� ���� �� ���� 
 */
public class Notepad {
	
	/*�ɹ�����*/
	private String dirPath;//��� 
	private String fileName;//���� ��
	private String content;//����
	
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
