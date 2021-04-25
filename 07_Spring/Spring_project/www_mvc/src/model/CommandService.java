package model; 

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

public class CommandService{ 

    /** 
     * 기본 생성자 
     */ 
    public CommandService() { 
        super(); 
    } 
    
    public StringBuffer getMyInfo() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("<li> 이름 : 홍길동 <br>");
    	sb.append("<li> 전화번호 : 010-1111-1111 <br>");
    	sb.append("<li> 주소 : 서울시 서초구 남부터미널 <br>");
    	sb.append("<li> 성격 : 친절함 <br>");
    	
    	return sb;
    }

    public StringBuffer getHello(){ 
        StringBuffer sb = new StringBuffer(); 
        sb.append("<li> 안녕하세요..MVC 입니다.<br>"); 
        sb.append("<li> Template Page<br>"); 
        sb.append("<li> URI Command Pattern<br>"); 
        sb.append("<li> Properties 파일을 이용한 처리입니다.<br>"); 
         
        return sb; 

    } 

    public String getDate(){ 
        Date dt = new Date(); 
        String str = dt.toLocaleString();  
         
        return str; 
    }

	public List<Map> teamList() {
		List<Map> list = new ArrayList<Map>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", "김길동");
		map.put("phone", "010-2222-2222");
		map.put("addr", "서울시 서초구 남부터미널");
		
		list.add(map);
		
		map = new HashMap<String,String>(); //그릇만 같고, 객체의 내용은 다른 곳에 저장
		map.put("name", "이길동");
		map.put("phone", "010-2222-3333");
		map.put("addr", "서울시 서초구 남부터미널");
		
		list.add(map);
		
		map = new HashMap<String,String>(); //그릇만 같고, 객체의 내용은 다른 곳에 저장
		map.put("name", "박길동");
		map.put("phone", "010-2222-4444");
		map.put("addr", "서울시 서초구 남부터미널");
		
		list.add(map);
		
		return list;
	} 

} 