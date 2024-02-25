package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";

        // GetMapping
        // 해당 url 로 요청이 들어오면 Controller를 찾아서 매핑
        
        // 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리
        // resources/templates/ (ViewName).html
        // model에 셋팅한 값을 뷰로 함께 전달
        
        // 웹 브라우저
        // localhost:8080/hello
        // 내장 톰캣 서버
        // 스프링 컨테이너 - helloController
        // 스프링 컨테이너 - viewResolver (Thymeleaf 템플릿 엔진 처리)
        // hello.html을 웹 브라우저로 반환
    }

    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";

        //MVC - Model, View, Controller
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;

        // ResponseBody
        // http 통신 프로토콜 헤더부 + 바디부
        // 바디부에 데이터를 직접 반환 (return 값으로)
        // ViewResolver 대신에 HttpMessageConverter 가 동작
        // 기본 문자 처리 : StringHttpMessageConverter
        // 기본 객체 처리 : MappingJackson2HttpMessageConverter
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello hellApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

        // 바디부에 JSON 으로 응답
        // key - value
    }

    static class Hello {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
