package com.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.model.NoticeDTO;
import com.study.model.NoticeService;
import com.study.notice.Utility;

@Controller
public class NoticeController {
	
	@Autowired
	@Qualifier("com.study.model.NoticeServiceImpl")
	private NoticeService service;
	
	@PostMapping("/delete")
	public String delete(int noticeno, String passwd) {
		
		Map map = new HashMap();
		map.put("noticeno", noticeno);
		map.put("passwd", passwd);
		
		int pcnt = service.passwd(map);
		int cnt = 0;
		if(pcnt == 1) cnt = service.delete(noticeno);
		
		if(pcnt != 1) {
			return "passwdError";
		}else if(cnt == 1) {
			return "redirect:list";
		}else {
			return "error";
		}
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		return "/delete";
	}
	
	@PostMapping("/update")
	public String update(NoticeDTO dto) {
		
		Map map = new HashMap();
		map.put("noticeno", dto.getNoticeno());
		map.put("passwd", dto.getPasswd());
		
		int pcnt = service.passwd(map);//pcnt : 패스워드 cnt
		
		int cnt = 0;
		if(pcnt == 1) cnt = service.update(dto);
		
		if(pcnt != 1) {
			return "passwdError";
		}else if(cnt == 1) {
			return "redirect:list";
		}else {
			return "error";
		}
	}
	
	@GetMapping("/update")//tiles의 name과 같아야함
	public String update(int noticeno, Model model) {
		
		model.addAttribute("dto", service.read(noticeno));
		
		return "/update";
	}
	
	@GetMapping("/read")
	public String read(int noticeno, Model model) {
		//조회수 증가
		service.upCnt(noticeno);
		
		NoticeDTO dto = service.read(noticeno);
		
		String content = dto.getContent().replaceAll("\r\n", "<br>");
		
		dto.setContent(content);
		
		model.addAttribute("dto", dto);
		
		return "/read";
	}
	
	//create 폼이 보여질 수 있도록 선언
	@GetMapping("/create")//요청 URL
	public String create() {
		return "/create";
	}
	
	@PostMapping("create")
	public String create(NoticeDTO dto) {
		if(service.create(dto)==1) {
			return "redirect:list";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		//검색 관련
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		
		//null을 빈 객체로 변환 -> 안그러면 체크에서 걸리기 때문...?
		if(col.equals("total")) {
			word = "";
		}
		
		//페이지 관련
		int nowPage = 1;
		if(request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		int recordPerPage = 3;//한 페이지에서 보여줄 레코드 개수
		
		//마리아 db에서 가져올 순서 앞부분 0부터 시작
		//(오라클 같은 경우는 0~0까지 순서가 계속 바뀌지만 - 삼중쿼리, 마리아 db는 앞만 바뀜 0~5, 1~5 - limit 값)
		int sno = ((nowPage-1) * recordPerPage);//그래서 앞 부분만 계산
		
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("cnt", recordPerPage);//recordPerPage : 몇 개 갖고올거냐
		
		int total = service.total(map);
		List<NoticeDTO> list = service.list(map);
		
		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		
		return "/list";
	}
	
	//홈페이지가 열리도록 하는 작업
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );

		return "/home";
	}
}
