package resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {
	 private static SqlSessionFactory sqlSessionFactory;
	 //초기화 블록 : 멤버 변수 초기화하는 블록
	    static {
	        try {
	        	String resource = "resources/config.xml";
	            Reader reader = Resources.getResourceAsReader(resource);
	 
	            if (sqlSessionFactory == null) {
	                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	             
	    			Class[] mapper = {board.member.MemberMapper.class};
	    			for(Class m : mapper){
	    				sqlSessionFactory.getConfiguration().addMapper(m);
	    			}             
	            }
	        }
	        catch (FileNotFoundException fileNotFoundException) {
	            fileNotFoundException.printStackTrace();
	        }
	        catch (IOException iOException) {
	            iOException.printStackTrace();
	        }
	    }
	    public static SqlSessionFactory getSqlSessionFactory() {
	        return sqlSessionFactory;
	    }
}
