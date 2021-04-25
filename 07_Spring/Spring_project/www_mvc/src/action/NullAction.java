package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		 System.out.println("NullAction Loading"); 
         
	     // Context Path을 제거한 경로 지정 
	     return "/view/nullCommand.jsp"; 
	}

}
