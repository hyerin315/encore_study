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

@WebServlet("/ServletTest")//서블릿 파일을 실행할 수 있는 경로(경로 바꾸고 싶음면 " "안의 경로 변경), 이름은 자바에서 자동으로 설정해줌
public class ServletTest extends HttpServlet {//Http를 구현해둠
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ServletTest() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
	    //어떤 방식으로 오던 doGet으로 처리하게끔

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 클라이언트가 보낸 값을 출력하는 것 (실제로 이런식으로 사용은 안함)
			PrintWriter out = response.getWriter();//응답 페이지에 출력할 outputStream out 생성
			
			//클라이언트가 전송한 폼 파라메터 받음
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String gen = request.getParameter("gen");
			String[] hobby = request.getParameterValues("hobby");
			int grade = Integer.parseInt(request.getParameter("grade"));
			
			//응답 페이지 만듦
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
