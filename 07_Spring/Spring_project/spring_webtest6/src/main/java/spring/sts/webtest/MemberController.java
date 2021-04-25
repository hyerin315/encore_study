package spring.sts.webtest;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import spring.model.member.MemberDTO;
import spring.model.member.MemberMapper;
import spring.utility.webtest.Utility;

@Controller
public class MemberController {
	
	@Autowired
	private MemberMapper mapper;
	
	@GetMapping("member/download")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletContext ctx = request.getSession().getServletContext();
		// 절대 경로
		String dir = ctx.getRealPath(request.getParameter("dir"));
		String filename = request.getParameter("filename");
		byte[] files = FileUtils.readFileToByteArray(new File(dir, filename));

		// Content-Transfer-Encoding : 전송 데이타의 body를 인코딩한 방법을 표시함
		// -> "~ 이런 파일이 올 건데 무조건 다운 해줘, 한글이면 깨지지 않게 해줘~"
		response.setHeader("Content-disposition",
				"attachment; fileName=\"" + URLEncoder.encode(filename, "UTF-8") + "\";");

		// Content-Disposition가 attachment와 함게 설정되었다면
		// 'Save As'로 파일을 제안하는지 여부에 따라 브라우저가 실행한다.
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentType("application/octet-stream");
		response.setContentLength(files.length);
		response.getOutputStream().write(files);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	@PostMapping("/member/updateFile")
	public String updateFileForm(MultipartFile fnameMF, String oldfile, HttpSession session, HttpServletRequest request) {
		String basePath = request.getRealPath("/storage");
		//무조건 파일을 얻어오기 때문에 사진이 없다면~의 if문 안써도 됨
		if(oldfile != null && !oldfile.equals("member.jpg")) {//원본파일 삭제
			Utility.deleteFile(basePath, oldfile);
		}
		//Storage 파일 저장
		Map map = new HashMap();
		map.put("id", session.getAttribute("id"));
		map.put("fname", Utility.saveFileSpring(fnameMF, basePath));//basePath는 스토리지 까지의 경로
		
		//DB에 파일명 변경
		int cnt = mapper.updateFileForm(map);
		
		if(cnt==1) {
			return "redirect:./read";
		}else {
			return "./error";
		}
	}
	
	@GetMapping("/member/updateFile")
	public String updateFileForm() {
		/*
		 * if(id == null) {//id가 null일 경우 id = (String)
		 * session.getAttribute("id");//세션에서 가져온다 }
		 * 
		 * MemberDTO dto = mapper.read(id);//id 값으로 읽어옴
		 * 
		 * model.addAttribute("dto", dto);//모델에 담아서 가져감
		 */		
		return "/member/updateFile";
	}
	
	/*
	 * - ReauestMapping : Get & Post Mapping 두 가지 방식으로 요청
	 * 1) 목록 같은 경우 메뉴에서 직접 선택하고 들어올 때는 get 방식
	 * 2) 검색을 하면 post 방식
	 * -> 그래서 2가지를 쓸 수 있는 RequestMapping 사용
	 */
	@RequestMapping("/admin/list")
	public String list(HttpServletRequest request) {
		// 검색관련------------------------
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));

		if (col.equals("total")) {
			word = "";
		}

		// 페이지관련-----------------------
		int nowPage = 1;// 현재 보고있는 페이지
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 5;// 한페이지당 보여줄 레코드갯수

		// DB에서 가져올 순번-----------------
		int sno = ((nowPage - 1) * recordPerPage) + 1;
		int eno = nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);

		int total = mapper.total(map);

		//List<MemberDTO> list = dao.list(map);
		List<MemberDTO> list = mapper.list(map);

		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

		// request에 Model사용 결과 담는다
		request.setAttribute("list", list);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("paging", paging);
		
		return "/member/list";
		
	}
	
	@PostMapping("/member/update")
	public String update(MemberDTO dto, Model model) {
		int cnt = mapper.update(dto);
		
		if(cnt == 1) {
			model.addAttribute("id", dto.getId());
			return "redirect:./read";
		}else {
			return "error";
		}
	}
	
	@GetMapping("/member/update")
	public String update(String id, Model model, HttpSession session) {
		/*
		 * - 어차피 로그인한 경우에만 보일 텐데, 왜 null값?
		 * 전달될 때 파라미터 값으로 url에 붙어 이동하지 않음(보안을 위해서)
		 * 나의 정보 - 정보 수정인 경우는 id를 갖고 있어서 괜찮지만,
		 * 이 경우는 세션에만 Id가 있기 때문에 회원목록에서 회원을 파라미터로 가져갈 때, null일 경우를 예상해야함
		 * + 세션 하나로 가져가도 되지만, 현재 이 페이지에서는 그렇게 하고 있어서 가져감
		 */		
		if(id == null) {//id가 null일 경우
			id = (String) session.getAttribute("id");//세션에서 가져온다
		}
		
		MemberDTO dto = mapper.read(id);//id 값으로 읽어옴
		
		model.addAttribute("dto", dto);//모델에 담아서 가져감
		
		return "/member/update";
	}
	
	@GetMapping("/member/read")
	public String read(String id, Model model, HttpSession session) {
		//세션에서 id를 갖고와야함 - String id에는 id가 안들어 있음 = null임
		if(id == null) {//id가 null일 경우
			id = (String) session.getAttribute("id");//세션에서 가져온다
		}
		MemberDTO dto = mapper.read(id);
		
		model.addAttribute("dto", dto);
		return "/member/read";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("id");
		//session.removeAttribute("grade");
		session.invalidate();//한 번 에 다 지우는 방법
		
		return "redirect:/";
	}
	
	@PostMapping("/member/login")
	//hidden에서 보내진 것도 map으로 다 들어옴 (Map<String, String>으로 인해
	public String login(@RequestParam Map<String, String> map,
			HttpSession session,
			HttpServletResponse response,
			HttpServletRequest request,
			Model model) {
		int cnt = mapper.loginCheck(map);
		
		if(cnt > 0) {//회원이다
			String grade = mapper.getGrade(map.get("id"));
			session.setAttribute("id", map.get("id"));
			session.setAttribute("grade", grade);
			//Cookie 저장 - id 저장 여부 및 id를 저장
			Cookie cookie = null;
			String c_id = request.getParameter("c_id");
			if(c_id != null) {
				cookie = new Cookie("c_id", "Y");//c_id에 Y값이 있어서 보기 좋게 써준 것
				cookie.setMaxAge(60 * 60 * 24 * 365);//1년 정도 쿠키를 저장하겠다(유지하겠다)
				response.addCookie(cookie);//요청지(client: 브라우저 컴) 쿠키 저장
				
				cookie = new Cookie("c_id_val", map.get("id"));
				cookie.setMaxAge(60 * 60 * 24 * 365);//1년 정도 쿠키를 저장하겠다(유지하겠다)
				response.addCookie(cookie);//요청지(client: 브라우저 컴) 쿠키 저장
		}else {
			//기존에 있다면 - 쿠키 삭제, 없으면 - 생성 x
			cookie = new Cookie("c_id", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			cookie = new Cookie("c_id_val", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);	
			}
		}//if(cnt > 0) end
		
		if (cnt > 0) {// = (cnt == 1) 도 상관 없음
			if (map.get("rurl") != null && !map.get("rurl").equals("")) {
				
				//read 페이지로 
				model.addAttribute("bbsno", map.get("bbsno"));
				model.addAttribute("nPage", map.get("nPage"));
				model.addAttribute("noePage", map.get("noePage"));
				model.addAttribute("col", map.get("col"));
				model.addAttribute("word", map.get("word"));
				
				return "redirect:" + map.get("rurl");
				
			} else {

				return "redirect:/";
			}
		} else {
			model.addAttribute("msg", "아이디 또는 비밀 번호를 잘못 입력했거나 <br>회원이 아닙니다. 회원 가입 해주세요");
			return "member/errorMsg";
		}
	}
	
	@GetMapping("/member/login")
	public String login(HttpServletRequest request) {
		/*----쿠키설정 내용시작----------------------------*/
		String c_id = ""; // ID 저장 여부를 저장하는 변수, Y(값)
		String c_id_val = ""; // ID 값

		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];

				if (cookie.getName().equals("c_id")) {//c_id로 쿠기 값(value)를 갖고올 수 있음
					c_id = cookie.getValue(); // Y
				} else if (cookie.getName().equals("c_id_val")) {
					c_id_val = cookie.getValue(); // user1...
				}
			}
		}
		/*----쿠키설정 내용 끝----------------------------*/
		request.setAttribute("c_id", c_id);
		request.setAttribute("c_id_val", c_id_val);
		
		return "/member/login";
	}
	
	@PostMapping("/member/create")
	public String create(MemberDTO dto, HttpServletRequest request) {
		String upDir = request.getRealPath("/storage");
		String fname = Utility.saveFileSpring(dto.getFnameMF(), upDir);
		int size = (int) dto.getFnameMF().getSize();
		if(size>0) {
			dto.setFname(fname);
		}else {
			dto.setFname("member.jpg");
		}
		
		if(mapper.create(dto) > 0) {
			return "redirect:/";
		}else {
			return "error";
		}
	}
	
	@GetMapping(value="/member/emailcheck", produces="application/json; chareset=utf-8")
	@ResponseBody
	public Map<String,String> emailcheck(String email){
		int cnt = mapper.duplicatedEmail(email);
		
		Map<String, String> map = new HashMap<String, String>();
		if(cnt>0) {
			map.put("str", email+"이 중복되어 사용할 수 없습니다.");
			map.put("color", "red");
		}else {
			map.put("str", email + "을 사용할 수 있습니다.");
			map.put("color", "blue");
		}
		return map;
	}
	
	@GetMapping(value="/member/idcheck", produces="application/json; chareset=utf-8")
	@ResponseBody
	public Map<String,String> idcheck(String id){
		int cnt = mapper.duplicatedId(id);
		
		Map<String, String> map = new HashMap<String, String>();
		if(cnt>0) {
			map.put("str", id+"는 중복되어 사용할 수 없습니다.");
			map.put("color", "red");
		}else {
			map.put("str", id + "는 사용할 수 있습니다.");
			map.put("color", "blue");
		}
		return map;
	}
	
	@GetMapping("/member/agree")
	public String agree() {
		
		return "/member/agree";
	}
	
	@PostMapping("/member/createForm")
	public String create() {
		return "/member/create";
	}

}
