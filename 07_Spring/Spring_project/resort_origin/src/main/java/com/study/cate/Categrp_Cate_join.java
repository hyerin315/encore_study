package com.study.cate;

import lombok.Data;

@Data
public class Categrp_Cate_join {
	/** categrp table 에서 읽어올 데이터들 **/
	private int 	r_categrpno;
	private String 	r_name;
	/** cate_table 에서 읽어올 데이터를 저장할 필드들 **/
	private int 	cateno;
	private int 	categrpno;
	private String 	name; //카테고리 명
	private int 	seqno;
	private String 	visible;
	private String 	rdate;
	private int 	cnt;
}
