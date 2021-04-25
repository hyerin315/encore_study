package spring.model.bbs;

import java.util.List;
import java.util.Map;

public interface BbsMapper {
	List<BbsDTO> list(Map map);
	int total(Map map);
	int create(BbsDTO dto);
	int upViewcnt(int bbsno);//void여도 상관없음 (bbs와 맞춰주기 위함)
	BbsDTO read(int bbsno);
	int update(BbsDTO dto);
	int passCheck(Map map);
	int checkRefnum(int bbsno);
	int delete(int bbsno);
	BbsDTO readReply(int bbsno);
	int upAnsnum(Map map);//void여도 상관없음 (bbs와 맞춰주기 위함)
	int createReply(BbsDTO dto);
}
