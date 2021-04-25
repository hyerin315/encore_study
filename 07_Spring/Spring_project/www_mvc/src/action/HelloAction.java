package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class HelloAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		 CommandService commandService= new CommandService(); 
         
	        StringBuffer sb = commandService.getHello(); 
	         
	        request.setAttribute("hello", sb); 

	        System.out.println("HelloAction Loading"); 
	         
	        // Context Path을 제거한 경로 지정 
	        return "/view/hello.jsp"; 
	}

}
