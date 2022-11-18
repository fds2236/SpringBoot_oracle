package com.kh.RestApi.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data // Get, Set, ToString, 생성자 모두 자동으로 생성
@Entity
@Table(name = "member_Info")
public class MemberInfo {
    @Id // 프라이머리 키
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 프라이머리 키
    private String userId;
    private String pwd;
    private String name;
    private String email;
    private LocalDateTime join; // join이 오라클에서는 괜찮지만 mysql에서는 예약어
}
