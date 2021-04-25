package com.study.notice;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//설정을 나타내는 클래스

@Configuration
@PropertySource("classpath:/application.properties")//classPath는 자바 리소스 안의 scr 폴더 안에 있는 것들을 말함...?
@MapperScan(basePackages= {"com.study.model"})
public class DatabaseConfiguration {
	 @Autowired
	  private ApplicationContext applicationContext;
	  
	  @Bean
	  @ConfigurationProperties(prefix="spring.datasource.hikari") // 설정 파일의 접두사 선언 
	  public HikariConfig hikariConfig() {
	      return new HikariConfig();
	  }
	  
	  //↓ 위에껄 가지고 아래에서
	  
	  @Bean
	  public DataSource dataSource() throws Exception{
	      DataSource dataSource = new HikariDataSource(hikariConfig());
	      System.out.println(dataSource.toString());  // 정상적으로 연결 되었는지 해시코드로 확인
	      return dataSource;
	  }
	  
	  //↓ 위에껄 가지고 아래에서
	  
	  @Bean
	  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
	      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	      sqlSessionFactoryBean.setDataSource(dataSource);
	      sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/**/*.xml"));   
	      return sqlSessionFactoryBean.getObject();
	  }
	  
	  //↓ 위에껄 가지고 아래에서
	  
	  @Bean
	  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
	      return new SqlSessionTemplate(sqlSessionFactory);
	  }
}
