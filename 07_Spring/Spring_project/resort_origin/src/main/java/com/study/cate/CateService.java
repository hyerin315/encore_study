package com.study.cate;

import java.util.List;

public interface CateService {
	int create(CateVO vo);
	CateVO read(int cateno);
	int update(CateVO vo);
	int delete(int caateno);
	List<CateVO> list_by_categrpno(int categrpno);
	int update_seqno_up(int cateno);
	int update_seqno_down(int cateno);
	int update_visible(CateVO vo);
	int increaseCnt(int cateno);
	int decreaseCnt(int cateno);
	List<Categrp_Cate_join> list_join_by_categrpno(int categrpno);//Order by 절로 인해 여러개가 들어감으로 List 처리
}
