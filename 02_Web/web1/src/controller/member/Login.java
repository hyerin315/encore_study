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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//요청을 get방식으로 보내면 실행 : 로그인 폼을 주는 방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/loginForm.jsp");
		dispatcher.forward(request, response);//페이지를 이동하더라도 계속 가지고 다님 - 그래야 처리할 수 있음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//요청을 post방식으로 보내면 실행 : 로그인을 처리해주는 방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService service = new MemberService();
		String result = "member/loginForm.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//로그인 처리
		Member m = service.getMember(id);
		HttpSession session = null;//비연결 지향(응답을 하면 바로바로 끊음) - 기억시키려면 Session 필요
		if(m!= null && pwd.equals(m.getPwd())) {
			session = request.getSession();
			session.setAttribute("id", id);//세션이 끝날때(브라우저를 닫거나 session.invelidate()를 만날때까지) 유지
			
//			request.setAttribute("joinMsg", id+"님 로그인 성공"); //요청 끝나면 사라짐, 그래서 유지되려면 session으로 저장해야함
			result = "member/index.jsp";
		}
		
//		if (id1.equals(id) && pwd1.equals(pwd)) {
//			result = "test/result2.jsp";
//			request.setAttribute("id", id);//request에 정보저장 : 다음 페이지 넘어갈 때 값을 가져감 (원래 다음 페이지 넘어갈 때 초기화됨)
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(result);
		dispatcher.forward(request, response);
	}

}
