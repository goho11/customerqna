package kr.co.greenart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // compomentscan 포함
public class DemoApplication {

	// spring boot 메인 메서드 존재
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
