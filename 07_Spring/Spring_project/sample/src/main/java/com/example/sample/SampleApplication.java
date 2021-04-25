package com.example.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * SampleApplication은 자동구성이나,
 * com.example.sample안에서만 적용되기 때문에 
 * 이 패키지 밖에서 작용하려면 아래처럼 @ComponentScan으로 경로를 적어줘야함
 * -> 하지만 그렇게 경로를 설정하면 명시된 패키지 경로로만 인식하기 때문에 *로 해주면 우리의 공통적인 패키지에 경로 다 갈 수 있음
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.*"})
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
