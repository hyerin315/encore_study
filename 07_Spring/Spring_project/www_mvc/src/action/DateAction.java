package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class DateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		 CommandService commandService= new CommandService(); 
         
	        String str = commandService.getDate(); 
	         
	        // 가져온 날짜 문자열을 request 객체에 저장 
	        request.setAttribute("date", str); 
	         
	        System.out.println("DateAction Loading");         
	         
	        // Context Path을 제거한 경로 지정 
	        return "/view/date.jsp"; 
	}

}
