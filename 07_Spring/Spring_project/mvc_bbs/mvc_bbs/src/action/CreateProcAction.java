package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsDAO;
import model.BbsDTO;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8"); //post 방식의 한글처리 (이전에 한 건 get 방식의 한글처리)
		BbsDTO dto = new BbsDTO();
		dto.setWname(request.getParameter("wname"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		BbsDAO dao = new BbsDAO();
		request.setAttribute("flag", dao.create(dto));
		return "/view/createProc.jsp";
	}

}
