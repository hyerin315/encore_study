package com.encore.dao.define;

import java.util.ArrayList;

import com.encore.vo.EmployeeSchedule;

public interface EmployeeDaoDefine {
	ArrayList <EmployeeSchedule> getAllEmployee(); //직원명단 호출
	ArrayList<EmployeeSchedule> addEmpSchedule(EmployeeSchedule e);//직원스케줄등록
	EmployeeSchedule searchSchedule(String empCode);//empcode로 검색해서 스케줄 검색
	void updateSchdule(String empCode, String offday);//empcode로 검색해서 휴일업데이트
	void deleteEmployeeSchedule (String empCode);//empcode로 받아서 삭제
	EmployeeSchedule selectByEmpCode(String eNum);
}