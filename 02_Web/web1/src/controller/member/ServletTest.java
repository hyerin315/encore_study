package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */

@WebServlet("/ServletTest")//���� ������ ������ �� �ִ� ���(��� �ٲٰ� ������ " "���� ��� ����), �̸��� �ڹٿ��� �ڵ����� ��������
public class ServletTest extends HttpServlet {//Http�� �����ص�
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ServletTest() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	    //� ������� ���� doGet���� ó���ϰԲ�

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Ŭ���̾�Ʈ�� ���� ���� ����ϴ� �� (������ �̷������� ����� ����)
			PrintWriter out = response.getWriter();//���� �������� ����� outputStream out ����
			
			//Ŭ���̾�Ʈ�� ������ �� �Ķ���� ����
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String gen = request.getParameter("gen");
			String[] hobby = request.getParameterValues("hobby");
			int grade = Integer.parseInt(request.getParameter("grade"));
			
			//���� ������ ����
			out.print("<html><body>");
			out.println("id:"+id+"<br/>");
			out.println("pwd:"+pwd+"<br/>");
			out.println("gen:"+gen+"<br/>");
			out.print("hobby:");
			for(String s:hobby){
				out.print(s);
			}
			out.println("<br/>");
			out.println("grade:"+grade+"<br/>");
			out.print("<body><html>");
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
