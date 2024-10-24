package kr.co.greenart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.co.greenart.web.customer.qna.QNA;
import kr.co.greenart.web.customer.qna.QNAMapper;

// CommandLineRunner : 서버 실행시 특정 동작을 실행
@SpringBootApplication // compomentscan 포함
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private QNAMapper mapper;

	// spring boot 메인 메서드 존재
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i = 2; i < 7; i++) {
			mapper.save(QNA.builder().title("title" + i)
									 .content("content" + i)
									 .username("username" + i)
									 .password("password" + i)
									 .build());
		}
	}

}
