package hello.hellospring.service;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
        // 스프링이 뜰 때 스프링 컨테이너에 MemerService Bean 등록
    }

    @Bean
    public JdbcMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
//        DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체다.
//        스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둔다.
//        그래서 DI를 받을 수 있다.
//        다형성(구현체를 변경)을 DI덕분에 쉽게 사용할 수 있음
//        기존 업무코드 수정없이
//        개발폐쇄원칙(SOLID - OCP)
//        return new JdbcTemplateMemberRepository(dataSource);
    }
}
