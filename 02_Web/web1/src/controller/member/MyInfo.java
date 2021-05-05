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
		HttpSession session = request.getSession(false);//�ƹ��͵� �ȳ־��ָ� default ���� true�� �� (true : ������ ������ ���� ����, false : ������ ������ null)
		String login_id = (String) session.getAttribute("id");//Object�� ĳ���� �Ǳ� ������ �տ� �߰� �������
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
		//getParameter(�Ķ���� �̸�) : �� �Ķ���� �� �б�
		//getAttribyte(Ű) : scope ��ü���� �� ����
		
		//���� ��� 1)
//		HttpSession session = request.getSession(false);
//		String id = (String) session.getAttribute("id");
		
		//���� ��� 2)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		MemberService service = new MemberService();
		service.editMember(new Member(id, pwd, "", email));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/index.jsp");
		dispatcher.forward(request, response);
		
	}

}
