package com.encore.service.define;

import java.util.ArrayList;
import java.util.Scanner;

import com.encore.vo.EmployeeSchedule;

public interface EmployeeServiceDefine {
	void getAllEmployee(Scanner sc); //전체직원목록->콘솔창에 프린트
	void addEmpSchedule(Scanner sc); //직원스케줄추가->스캔으로입력받아서 엑셀파일에 저장
	void searchSchedule(Scanner sc); //직원스케줄 확인->엑셀파일 읽어와서 콘솔창에 프린트 (전체직원목록)과 기능겹침
	void updateSchdule(Scanner sc);	//empcod입력받아서 offday 업데이트
	void deleteEmployeeSchedule(Scanner sc);//empcode입력받아서 스케줄 삭제->엑셀파일에서도 삭제

	
	void excelRead(String path);
	void excelwrite(String path);

}

