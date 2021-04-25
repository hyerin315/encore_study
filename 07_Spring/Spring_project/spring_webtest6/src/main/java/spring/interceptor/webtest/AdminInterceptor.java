package spring.interceptor.webtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import spring.utility.webtest.Utility;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	//주소창에 요청해서 응답하기 전에 먼저 호출되어짐 (= 요청 주소 결과 생성 전에 실행)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(true);
		
		System.out.println("preHadle executed");
		String grade = Utility.checkNull((String)session.getAttribute("grade"));
		
		if(grade.equals("A")) {
			return true; //요청 페이지로 계속 진행(admin/list)
		}else {
			//로그인 페이지로 이동(admin/list 요청처리 대신)
			response.sendRedirect(request.getContextPath() + "/member/login");
			return false;
		}
	}

	
	@Override
	//요청 처리 완료 후 호출
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle executed");
		modelAndView.addObject("admin", "관리자 관련 기능을 출력합니다.");
		
	}

	
	@Override
	//jsp 등의 뷰페이지가 보여지기 전에, 출력 전에 작동
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompltion executed");
	}
	
	

}
