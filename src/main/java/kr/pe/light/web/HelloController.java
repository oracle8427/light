package kr.pe.light.web;

import kr.pe.light.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @RestController :
 *      JSON 을 반환한다.
 *      Spring 3버전에서 메소드 단위로 선언했던 @ResponseBody 애너테이션을, 클래스(Controller) 단위로 적용한다.
 *  @GetMapping
 *      @RequestMapping(method = RequestMethod.GET) 의 축약형
 * */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
