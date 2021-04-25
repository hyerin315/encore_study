package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandService;

public class MyinfoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//1. model 사용
		CommandService service = new CommandService();
		StringBuffer sb = service.getMyInfo();
		//2. 결과 request에 저장
		
		request.setAttribute("myinfo", sb);
		//3. 그 결과를 보여줄 view 페이지 리턴
		return "/view/myinfo.jsp"; 
		//forward 할 때는, / 맨 앞에 꼭 써주기
	}

}
