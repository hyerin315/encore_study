package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.board.Board;
import board.board.BoardService;
import board.member.Member;
import board.member.MemberService;

/**
 * Servlet implementation class Join
 */

//서블릿 = 컨트롤러 역할
//회원가입을 담당하는 서블릿

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		ArrayList<Board> list = service.getAll();
		request.setAttribute("list", list);
		
		//RequestDispatcher : 요청을 보낸 클라리언트에 응답 페이지 전송 담당
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join_form.jsp");
		//서버내에서 페이지 이동 : forward
		dispatcher.forward(request, response);
//		request.setCharacterEncoding("euc-kr");
//		response.setCharacterEncoding("euc-kr");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>");
//		out.print("<h1>회원가입 완료</h1>");
//		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService(); //검색, 저장 기능이 여기에 모두 저장되어 있음
		
		
        request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		
		//전송한 파라메터를 받아 출력하려면 아래처럼 진행
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
//		out.print("<html><body>");
//		out.print("<h1>회원가입 완료</h1>");
//		out.print("<h3>");
//		out.print("id: "+id);
//		out.print("pwd: "+pwd);
//		out.print("name: "+name);
//		out.print("email: "+email);
//		out.print("</h3>");
//		out.print("<h1>회원가입 완료</h1>");
//		out.print("</body></html>");
		
		//DB저장
		service.addMember(new Member(id, pwd, name, email));
		request.setAttribute("joinMsg", id+"님 회원가입이 완료되었습니다. ");//키이름 : 변수이름 아님
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/index.jsp");
		dispatcher.forward(request, response);

	}
}
