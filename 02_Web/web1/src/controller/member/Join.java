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

//���� = ��Ʈ�ѷ� ����
//ȸ�������� ����ϴ� ����

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
		
		//RequestDispatcher : ��û�� ���� Ŭ�󸮾�Ʈ�� ���� ������ ���� ���
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join_form.jsp");
		//���������� ������ �̵� : forward
		dispatcher.forward(request, response);
//		request.setCharacterEncoding("euc-kr");
//		response.setCharacterEncoding("euc-kr");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>");
//		out.print("<h1>ȸ������ �Ϸ�</h1>");
//		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService(); //�˻�, ���� ����� ���⿡ ��� ����Ǿ� ����
		
		
        request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		
		//������ �Ķ���͸� �޾� ����Ϸ��� �Ʒ�ó�� ����
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
//		out.print("<html><body>");
//		out.print("<h1>ȸ������ �Ϸ�</h1>");
//		out.print("<h3>");
//		out.print("id: "+id);
//		out.print("pwd: "+pwd);
//		out.print("name: "+name);
//		out.print("email: "+email);
//		out.print("</h3>");
//		out.print("<h1>ȸ������ �Ϸ�</h1>");
//		out.print("</body></html>");
		
		//DB����
		service.addMember(new Member(id, pwd, name, email));
		request.setAttribute("joinMsg", id+"�� ȸ�������� �Ϸ�Ǿ����ϴ�. ");//Ű�̸� : �����̸� �ƴ�
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/index.jsp");
		dispatcher.forward(request, response);

	}
}
