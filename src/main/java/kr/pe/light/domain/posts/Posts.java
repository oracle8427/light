package kr.pe.light.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*
 * @Entity
 *  테이블과 링크될 클래스
 *  기본값으로 클래스의 카멜케이스 이름과 언더스코어 네이믕으로 테이블 이름을 매칭한다.
 *  SalesManager -> sales_manager
 *
 * @Id
 *  테이블의 PK
 *
 * @GeneratedValue
 *  PK 생성 규칙
 *  스프링 부트 2.0 에서는 GenerationType.IDENTITY 를 추가해야만 auto_increment 가 적용된다.
 *  스프링 부트 2.0과 1.5의 차이
 *      1.5 useNewIdGeneratorMappings = false
 *      2.0 useNewIdGeneratorMappings = true
 *  Hibernate 의 id 생성 전략
 *  Hibernate 5.0 ( boot 2.x ) 부터 MySQL 의 GenerationType.AUTO 는 IDENTITY 가 아닌 TABLE 을 기본 시퀀스 전략으로 선택
 *  spring boot 1.5 에서는 Hibernate 5.0 을 쓰더라도 useNewIdGeneratorMappings 값이 false 이므로
 *      GenerationType.IDENTITY 가 선택
 *  spring boot 2.0 에서는 Hibernate 5.0 를 쓰면 useNewIdGeneratorMappings 값이 true 이므로 TABLE 이 선택된다.
 * */
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
