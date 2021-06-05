package kr.pe.light.web;

import kr.pe.light.TestHelper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/*
 *  @WebMvcTest
 *      Web(Spring MVC)에 집중할 수 있는 애노테이션
 *      선언할 경우, @Controller, @ControllerAdvice 등을 사용할 수 있다.
 *      @Service, @Component, @Repository 등은 사용할 수 없다.
 * */
@WebMvcTest
public class HelloControllerTest extends TestHelper {

    /* MVC 테스트의 시작점 ( HTTP GET, POST 등에 대한 API 테스트를 할 수 있다. * */
    @Autowired
    protected MockMvc mockMvc;

    /*
     *  .andExpect(status().isOk())
     *      mvc.perform 의 결과를 검증
     *      HTTP Header 의 Status 를 검증
     *  .andExpect(content().string(hello))
     *      mvc.perform 의 결과를 검증
     *      응답 본문의 내용을 검증
     *  */
    @Test
    public void helloTest() throws Exception {
        String hello = "hello";

        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(hello));
    }
}
