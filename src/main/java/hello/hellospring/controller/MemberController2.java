package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import hello.hellospring.service.MemberService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController2 {

    private final MemberService2 memberService2;

    @Autowired
    public MemberController2(MemberService2 memberService) {
        this.memberService2 = memberService;

        // 스프링 빈을 등록하는 2가지 방법

        // 2. 자바코드로 직접 스프링 빈 등록
        // @Configuration 클래스 하위의 @Bean 을 스프링 빈으로 등록
        
        // 실무에서 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용
        // 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 할 경우 직접 스프링 빈 등록을 사용

        // @Autowired는 스프링 빈인 경우에만 동작한다.
    }

}
