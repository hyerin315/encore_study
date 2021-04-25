package controller; 
 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.Iterator; 
import java.util.Map; 
import java.util.Properties; 
 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import action.NullAction; 
import action.Action; 
 
public class Controller extends HttpServlet { //HttpServlet의 do get 호출 
    private boolean usingTemplate = false; 
    private String templatePage = null; 
    
    //명령어=명령처리Action객체
    private Map map = new java.util.HashMap(); 
     
    public void init(ServletConfig config) throws ServletException { //호출되기 바로 직전에 호출됨 (아기 메소드)
        String configFile = config.getInitParameter("configFile"); 
        //Param-value를 얻어옴
         
        Properties prop = new Properties(); //Properties는 Properties에 넣을 수 있음
        FileInputStream fis = null; 
        try { 
            fis = new FileInputStream(configFile); //config파일로 부터 읽어오겠다
            prop.load(fis); //프로퍼티스가 갖고 있는 객체의 값을 읽어오는 것
        } catch (IOException e) { 
            throw new ServletException(e); 
        } finally { 
            if (fis != null) try { fis.close(); } catch(IOException ex) {} 
        } 
         
        Iterator keyIter = prop.keySet().iterator(); 
        //키값을 set 구조(중복되지 않는 값들로 가져오는, 인덱스가 없는 값)로 iterator로 정렬하며 가져옴
        while( keyIter.hasNext() ) { 
            String command = (String)keyIter.next(); 
            System.out.println("command: " + command); 
            //콘솔창에 프린트

            String handlerClassName = prop.getProperty(command).trim();
            //value값이 문자열 객체이지, 액션 객체는 아님
            System.out.println("handlerClassName: " + handlerClassName); 
            //콘솔창에 프린트
            
            try { 
                //클래스를 JVM으로 로딩합니다. 
                Class handlerClass = Class.forName(handlerClassName); //액션 객체로 생성
                 
                //읽어들인 클래의 객체를 생성합니다. (오브젝트 형으로, 실제 오브젝트는 아님 - 오브젝트 객체로 형변환 된 것)
                Object handlerInstance = handlerClass.newInstance(); 
                //줄이 그어진 이유 : 이거 대신 다른 걸 써라 (대용할 수 있는 몇가지가 나와있어, 알려주진 않을거지만!) - 하지만 써도 됨
                 
                //MAP에 키와 각 클래스별 객체가 저장합니다. 
                map.put(command, handlerInstance); //서버가 구동될때
                
            } catch (ClassNotFoundException e) { 
                throw new ServletException(e); 
            } catch (InstantiationException e) { 
                throw new ServletException(e); 
            } catch (IllegalAccessException e) { 
                throw new ServletException(e); 
            } 
        } 
      
        templatePage = config.getInitParameter("templatePage"); 
        //Param-value 읽어옴
        
        if (templatePage != null && !templatePage.equals("")) { 
            usingTemplate = true; // 템플릿 페이지 존재 (템플릿으로 보여줘)
        } 
    } 
 
    public void doGet( //상속받은 자식꺼부터 실행
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
 
    protected void doPost( 
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
     
    private void process( //URL상 명령어를 추출
        HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException { 
 
    	//클라이언트가 어떤 내용을 요청했는지 판단하는 부분
        String command = request.getRequestURI(); 
        System.out.println("RequestURI: " + request.getRequestURI()); 
        
        //command = URI:/www_mvc/mvc/list.do
        if (command.indexOf(request.getContextPath()) == 0) { 
        	//request.getURI의 루트값(?) : /www_mvc/
            command = command.substring(request.getContextPath().length());
            //request.getContextPath().length() = 8
            //command.substring(request.getContextPath().length()); = URI.substring(8) = /mvc/list.do 추출을 의미
            System.out.println("command: " + command); //콘솔창에 프린트
        } //명령어에 해당하는 키값을 맵에서 뽑아내는 것..?
         
 
        Action action =  
            (Action)map.get(command); //제대로 명령어가 갔다면 액션으로 가는데
         
        // 핸들러가 없는 경우 
        if (action == null) { //제대로 명령어를 입력하지 않으면 null
            action = new NullAction(); 
        } 
        //판단 끝
         
        String viewPage = null; 
        try { 
 
            viewPage = action.execute(request, response); 
        } catch(Throwable e) { 
            throw new ServletException(e); 
        } 
         
        if (usingTemplate) { 
            request.setAttribute("CONTENT_PAGE", viewPage); //리턴받은 뷰 페이지에 대한 정보를 request에 CONTENT_PAGE로 저장
        } 
        
        //forward 액션 태그
        RequestDispatcher dispatcher = 
           request.getRequestDispatcher( 
                   usingTemplate ? templatePage : viewPage); 
                   //삼항연산자 : ture이면 근접한 애가 리턴, false면 멀리 있는 애가 리턴
                   //useinTemplate이 ture면 템플릿 페이지를 가져오고, false면 viewPage를 보여주겠다
        dispatcher.forward(request, response); 
    } 
} 