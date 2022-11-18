package com.kh.RestApi.entity;

import lombok.Data;

import javax.persistence.*;

//

@Data // @Data : get,set,생성자, ToString 자동으로 다 만들어 줌
@Entity
public class Customer {
    @Id // @Id : id를 프라이머리키로 지정
    // @GeneratedValue 생성 전략 : AUTO, IDENTITY, SEQUENCE, TABLE
    @GeneratedValue(strategy = GenerationType.AUTO)
    // 연결 확인 : http://localhost:8111/customer?id=100&name=정금종&address=충북 청주시&firstPhone=01012345678
    private int id;
    private String name; // 별 다른 어노테이션 없으면 String 최대 255자 @Column(length=500) 이용
    @Column(length=1024)
    private String address;
    private String firstPhone; // 포스트맨 입력시 자바 카멜 표기법 기준(DB에는 first_phone으로 들어감)
}
