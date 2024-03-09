package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // Controller 어노테이션이 있으면 스프링이 뜰 때
    // 스프링 컨테이너에서 스프링 빈으로 관리됨

    // private final MemberService memberService = new MemberService(new MemoryMemberRepository());
    // 객체를 new로 생성해서 쓰면 스프링 컨테이너에서 관리하지 못함

    //    의존성 주입 3가지 방법
//    1. 생성자 주입
//    가장 추천. 생성하는 시점에 주입 후 변경 못하도록.
    private final MemberService memberService;

//    2. 필드 주입
//    @Autowired private MemberService memberService;

//    3. setter주입
//    setter 함수에서 주입
//    외부에서 호출이 가능하기 때문에 비추

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // 생성자에 Autowired -> MemberController가 뜰 때 MemberService 스프링 빈을 가져다 스프링 컨테이너에 넣어줌
        // 단, MemberService도 스프링 컨테이너가 관리 대상으로 찾을 수 있도록 @Service 어노테이션 붙여야 함
        // Dependency Injection (의존성 주입)

        // 스프링 빈을 등록하는 2가지 방법

        // 1. 컴포넌트 스캔 (지금)
        // 스프링이 올라올 때 @Component 어노테이션을 포함하는 아이들을 스프링 컨테이너에 등록
        // Controller, Service, Repository 모두 @Component이 있음
        // @Autowired 는 연관관계를 연결하는 역할 (빈A에서 빈B를 쓸 수 있게 해주는 역할)
        // 기본적으로 main메서드 하위 패키지 경로만 컴포넌트 스캔 대상

        // 2. 자바코드로 직접 스프링 빈 등록
        // 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱클톤으로 등록한다.
        // 유일하게 하나만 등록해서 공유한다.
        // 같은 스프링 빈이면 모두 같은 인스턴스
        // @Configuration 클래스에 설정
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        // html form 태그 method에 post방식으로 되어있으면 PostMapping 으로 넘어옴
        // 같은 url을 Mapping 을 다르게해서 사용 가능
        // 넘어온 key-value와 객체의 변수명을 매핑

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // 리다이렉트로 홈화면 호출
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}