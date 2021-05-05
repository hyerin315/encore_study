package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.member.Member;
import board.member.MemberService;

/**
 * Servlet implementation class MyInfo
 */

@WebServlet("/MyInfo")
public class MyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);//아무것도 안넣어주면 default 값인 true가 들어감 (true : 세선이 없으면 새로 생성, false : 세션이 없으면 null)
		String login_id = (String) session.getAttribute("id");//Object로 캐스팅 되기 때문에 앞에 추가 해줘야함
		MemberService service = new MemberService();
		Member m = service.getMember(login_id);
		request.setAttribute("m", m);

		RequestDispatcher dispatcher = request.getRequestDispatcher("member/myInfo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getParameter(파라메터 이름) : 폼 파라메터 값 읽기
		//getAttribyte(키) : scope 객체에서 값 추출
		
		//수정 방법 1)
//		HttpSession session = request.getSession(false);
//		String id = (String) session.getAttribute("id");
		
		//수정 방법 2)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		MemberService service = new MemberService();
		service.editMember(new Member(id, pwd, "", email));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/index.jsp");
		dispatcher.forward(request, response);
		
	}

}
