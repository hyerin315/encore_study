package spring.model.bbs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/*
 * Entity implementation class for Entity: BbsVO
 */

@Entity
@Table(name="BBS")
//클래스 명과 테이블 명이 다를 때는 Entity 뒤에 Table 꼭 적어줘야 함
public class BbsVO{
	@Id
	@SequenceGenerator(
			name = "bbsno_seq", 
			sequenceName = "SEQ_BBS",
			allocationSize = 1)
	@GeneratedValue(generator = "bbsno_seq")
	/** 번호 */
	private int bbsno;
	/** 글쓴이 */
	private String wname;
	/** 제목 */
	private String title;
	/** 내용 */
	private String content;
	/** 패스워드 */
	private String passwd;
	/** 조회수 */
	private int viewcnt;
	
	@Temporal(TemporalType.DATE)
	/** 등록일 */
	private Date wdate = new Date();
	
	/** 그룹 번호 */
	@SequenceGenerator(
			name = "bbsno_seq", 
			sequenceName = "SEQ_BBS",
			allocationSize = 1)
	@GeneratedValue(generator = "bbsno_seq")
	private int grpno;
	/** 답변 차수 */
	private int indent;
	/** 답변 순서 */
	private int ansnum;
	/** 추가된 업로드파일 이름 */
	private String filename;
	/** 추가된 업로드파일 size */
	private int filesize;
	
	@Transient
	private MultipartFile filenameMF;
	
	public BbsVO() {
		super();
	}

	public int getBbsno() {
		return bbsno;
	}

	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public int getGrpno() {
		return grpno;
	}

	public void setGrpno(int grpno) {
		this.grpno = grpno;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public int getAnsnum() {
		return ansnum;
	}

	public void setAnsnum(int ansnum) {
		this.ansnum = ansnum;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public MultipartFile getFilenameMF() {
		return filenameMF;
	}

	public void setFilenameMF(MultipartFile filenameMF) {
		this.filenameMF = filenameMF;
	}

	@Override
	public String toString() {
		return "BbsVO [bbsno=" + bbsno + ", wname=" + wname + ", title=" + title + ", content=" + content + ", passwd="
				+ passwd + ", viewcnt=" + viewcnt + ", wdate=" + wdate + ", grpno=" + grpno + ", indent=" + indent
				+ ", ansnum=" + ansnum + ", filename=" + filename + ", filesize=" + filesize + ", filenameMF="
				+ filenameMF + "]";
	}

}
