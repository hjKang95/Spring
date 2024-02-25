package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
		// main 메서드 실행 시
		// SpringApplication.run 실행
		// Tomcat 웹서버 실행 (스프링부트 라이브러리에 웹서버가 내장되어 같이 실행되므로 따로 환경 설정 필요X)

		// Spring Boot 라이브러리
		// build.gradle

		// Spring-boot-starter-web
		// spring-boot-starter-tomcat : 톰캣(웹서버)
		// spring-webmvc : 스프링 웹 MVC

		// spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)

		// spring-boot-starter(공통) : 스프링부트 + 스프링코어 + 로깅
		// spring-boot (spring core)
		// spring-boot-starter-logging : logback, slf4j

		// spring-boot-starter-test (테스트)
		// junit : 테스트 프레임워크
	}

}