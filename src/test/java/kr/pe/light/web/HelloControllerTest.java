package kr.pe.light.web;

import kr.pe.light.TestHelper;


import org.hamcrest.Matchers;
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

    /*
     *
     * MockMvcRequestBuilders.param
     *  API 테스트할 때 사용될 요청 파라미터를 설정한다.
     *  String 타입만 가능하므로, 문자열로 변환 해야한다.
     *
     * MockMvcResultMatchers.jsonPath
     *  JSON 응답값을 필드별로 검증할 수 있는 메소드
     *  "$"를 기준으로 필드명을 명시한다.
     *  $.name, $.amount
     * */
    @Test
    public void helloDtoTest() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(MockMvcRequestBuilders.get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(name)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.is(amount)));
    }
}
