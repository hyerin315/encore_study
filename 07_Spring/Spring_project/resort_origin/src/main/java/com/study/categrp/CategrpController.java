package com.study.categrp;

//Get : 데이터를 ?로 전달, Post : 폼으로 전달

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategrpController {
	@Autowired
	@Qualifier("com.study.categrp.CategrpServiceImpl")
	private CategrpService service;
	
	 public CategrpController() {
		    System.out.println("--> CategrpController created.");
		  }
		 
		  @RequestMapping(value = "/categrp/create", method = RequestMethod.GET)//Get방식일 때만 아래로 호출
		  public ModelAndView create() {
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("/categrp/create");//mav : model and view
		 
		    return mav;
		  }
		 
		  @RequestMapping(value = "/categrp/create", method = RequestMethod.POST)
		  public ModelAndView create(CategrpVO categrpVO) {//Post 방식으로 넘어온 값
		    ModelAndView mav = new ModelAndView();
		 
		    int cnt = this.service.create(categrpVO);//create은 creategrp의 insert 구문을 통해 처리됨
		    mav.addObject("cnt", cnt);
		 
		    mav.setViewName("/categrp/create_msg");//tiles에 있는 create_msg가 호출
		    return mav;//포워드가 됨
		  }
		 
		  @RequestMapping(value = "/categrp/list", method = RequestMethod.GET)
		  public ModelAndView list() {
		    ModelAndView mav = new ModelAndView();
		 
		    List<CategrpVO> list = this.service.list_seqno_asc();//출력 순서대로(오름차순)목록을 갖고와 확인
		    mav.addObject("list", list);
		 
		    mav.setViewName("/categrp/list"); // /webapp/categrp/list.jsp
		    return mav;//리턴되어진 뷰 네임은 tiles에서 찾음
		  }
		 
		  @RequestMapping(value = "/categrp/read_update", method = RequestMethod.GET)
		  public ModelAndView read_update(int categrpno) {
		 
		    ModelAndView mav = new ModelAndView();
		 
		    CategrpVO categrpVO = this.service.read(categrpno);
		    mav.addObject("categrpVO", categrpVO);
		 
		    List<CategrpVO> list = this.service.list_seqno_asc();
		    mav.addObject("list", list);
		 
		    mav.setViewName("/categrp/read_update");
		    return mav;
		  }
		 
		  @RequestMapping(value = "/categrp/update", method = RequestMethod.POST)
		  public ModelAndView update(CategrpVO categrpVO) {
		 
		    ModelAndView mav = new ModelAndView();
		 
		    int cnt = this.service.update(categrpVO);
		    mav.addObject("cnt", cnt);
		 
		    mav.setViewName("/categrp/update_msg");
		 
		    return mav;
		  }
		 
		  @RequestMapping(value = "/categrp/read_delete", method = RequestMethod.GET)
		  public ModelAndView read_delete(int categrpno) {//파라미터의 보내는 이름과 받는 변수명이 같아야함
		    ModelAndView mav = new ModelAndView();
		 
		    CategrpVO categrpVO = this.service.read(categrpno);
		    mav.addObject("categrpVO", categrpVO);
		 
		    List<CategrpVO> list = this.service.list_seqno_asc();
		    mav.addObject("list", list);
		 
		    mav.setViewName("/categrp/read_delete");
		    return mav;
		  }
		 
		  @RequestMapping(value = "/categrp/delete", method = RequestMethod.POST)
		  public ModelAndView delete(int categrpno) {
		    ModelAndView mav = new ModelAndView();
		 
		    int cnt = this.service.delete(categrpno);
		    mav.addObject("cnt", cnt);
		 
		    mav.setViewName("/categrp/delete_msg");
		 
		    return mav;
		  }
		 
		  @RequestMapping(value = "/categrp/update_seqno_up", method = RequestMethod.GET)
		  public ModelAndView update_seqno_up(int categrpno) {
		    ModelAndView mav = new ModelAndView();
		 
		    CategrpVO categrpVO = this.service.read(categrpno);
		    mav.addObject("categrpVO", categrpVO);
		 
		    int cnt = this.service.update_seqno_up(categrpno);
		    mav.addObject("cnt", cnt);
		 
		    mav.setViewName("/categrp/update_seqno_up_msg");
		    return mav;
		  }
		 
		  @RequestMapping(value = "/categrp/update_seqno_down", method = RequestMethod.GET)
		  public ModelAndView update_seqno_down(int categrpno) {
		    ModelAndView mav = new ModelAndView();
		 
		    CategrpVO categrpVO = this.service.read(categrpno);
		    mav.addObject("categrpVO", categrpVO);
		 
		    int cnt = this.service.update_seqno_down(categrpno);
		    mav.addObject("cnt", cnt);
		 
		    mav.setViewName("/categrp/update_seqno_down_msg");
		    return mav;
		  }
		 
		  @RequestMapping(value = "/categrp/update_visible", method = RequestMethod.GET)
		  public ModelAndView update_visible(int categrpno, String visible) {//categrpVO, DTO로 받을 수도 있음 (안에 두가지 객체가 모두 있으니까)
		    ModelAndView mav = new ModelAndView();
		    
		    //DTO로 받게 되면 아래 3줄 코딩 안해도 됨
		    Map map = new HashMap();
		    map.put("categrpno", categrpno);
		    map.put("visible", visible);
		 
		    int cnt = this.service.update_visible(map);
		 
		    mav.setViewName("redirect:/categrp/list");
		 
		    return mav;
		  }
}
