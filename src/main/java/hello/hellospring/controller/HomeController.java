package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
        // GetMapping("/") : 로컬호스트 8080으로 들어모면 호출됨
        // index.html은?
        // 웹브라우저에서 요청 전달 시 스트링 컨테이너에서 관련 컨트롤러가 있는지 먼저 찾고
        // 없으면 정적 컨텐츠(static) 파일을 찾음
        // 따라서 기존 정적 리소스는 무시되고
        // HomeController.home()이 먼저 실행되는 것
    }
}
