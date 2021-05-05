package board.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Dao {
	@Insert("insert into board values(seq_board.nextval,#{writer}, sysdate, #{title}, #{content})")
	void insert(Board b);
	
	@Select("select * from board order by num")
	ArrayList<Board> selectAll();
	
	@Select("select * from board where num=#{num}")
	Board selectByNum(@Param("num") int num);
	
	@Select("select * from board where writer=#{writer}")
	ArrayList<Board> selectByWriter(String writer);
	
	@Select("select * from board where titler like #{title}")
	ArrayList<Board> selectByTitle(@Param("title") String title);
	
	@Update("update board set w_date=sysdate, title=#{title}, content=#{content} where num=#{num}")
	void update(Board b);
	
	@Delete("delete board where num=#{num}")
	void delete(@Param("num") int num);
}
