package hello.hellospring.service;

import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.repository.MemoryMemberRepository2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService2 memberService2() {
        return new MemberService2(memberRepository2());
        // 스프링이 뜰 때 스프링 컨테이너에 MemerService2 Bean 등록
    }

    @Bean
    public MemoryMemberRepository2 memberRepository2() {
        return new MemoryMemberRepository2();
    }
}
