package kr.pe.light;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
 *  @RunWith 테스트를 진행할 때 JUnit 에 내장된 실행자 외에 다른 실행자를 실행시킨다.
 *      SpringRunner.class <=스프링 실행자 사용
 *      SpringBootTest<->Junit 사이의 연결자
 **/
@ExtendWith(SpringExtension.class)
public abstract class TestHelper {

}



