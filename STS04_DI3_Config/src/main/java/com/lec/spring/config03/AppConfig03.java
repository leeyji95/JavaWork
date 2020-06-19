package com.lec.spring.config03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.beans.Score;

@Configuration
public class AppConfig03 {
	
	@Bean
	public Score score1() { // id 가 'score1' 인 Score 빈 생성됨.
		return new Score(60, 30, 45, "노력부족");
	}
	

}
