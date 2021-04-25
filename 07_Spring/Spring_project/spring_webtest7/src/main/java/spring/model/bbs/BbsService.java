package spring.model.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.reply.ReplyMapper;

@Service
public class BbsService {
	
	@Autowired
	private BbsMapper mapper;
	@Autowired
	private ReplyMapper rmapper;
	@Autowired
	private BbsDAOJPA jpa;
	
	public void insert(BbsVO vo) {
		jpa.insertBbs(vo);
	}
	
	public void delete(int bbsno) throws Exception {
		//게시글에 댓글이 달려있는 상태에서 게시글을 지우면, 댓글들로 인해 에러가 나기 때문에 삭제하는 메소드 생성
		
		//댓글들을 지운다.
		rmapper.bdelete(bbsno);
		//부모글을 지운다
		mapper.delete(bbsno);
		
	}
	
	
}
