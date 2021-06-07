package kr.pe.light.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * @Getter : 선언된 모든 필드의 get 메소드를 생성한다.
 * @RequiredArgsConstructor :
 *  final 키워드가 선언된 모든 필드를 생성자 매개변수에 추가한다.
 *  final 키워드가 없는 필드는 생성자 매개변수에 추가되지 않는다.
 **/
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
