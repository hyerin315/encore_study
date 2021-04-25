package action; 

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

/** 
 * 표준 인터페이스 
 * @author stu 
 */ 
public interface Action { 
    /** 
     * 로직 처리 메소드 
     * @param request 내부 객체 
     * @param response 내부 객체 
     * @return 처리 결과 문자열 
     * @throws Throwable 
     */ 
    public String execute( //execute는 action이라는 추상 클래스 아래에서만 쓸 수 있음
        HttpServletRequest request, HttpServletResponse response) 
    throws Throwable; 
}  
