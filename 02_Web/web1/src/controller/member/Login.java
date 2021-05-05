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
	//��û�� get������� ������ ���� : �α��� ���� �ִ� ���
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������ �̵�
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/loginForm.jsp");
		dispatcher.forward(request, response);//�������� �̵��ϴ��� ��� ������ �ٴ� - �׷��� ó���� �� ����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//��û�� post������� ������ ���� : �α����� ó�����ִ� ���
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService service = new MemberService();
		String result = "member/loginForm.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//�α��� ó��
		Member m = service.getMember(id);
		HttpSession session = null;//�񿬰� ����(������ �ϸ� �ٷιٷ� ����) - ����Ű���� Session �ʿ�
		if(m!= null && pwd.equals(m.getPwd())) {
			session = request.getSession();
			session.setAttribute("id", id);//������ ������(�������� �ݰų� session.invelidate()�� ����������) ����
			
//			request.setAttribute("joinMsg", id+"�� �α��� ����"); //��û ������ �����, �׷��� �����Ƿ��� session���� �����ؾ���
			result = "member/index.jsp";
		}
		
//		if (id1.equals(id) && pwd1.equals(pwd)) {
//			result = "test/result2.jsp";
//			request.setAttribute("id", id);//request�� �������� : ���� ������ �Ѿ �� ���� ������ (���� ���� ������ �Ѿ �� �ʱ�ȭ��)
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(result);
		dispatcher.forward(request, response);
	}

}
