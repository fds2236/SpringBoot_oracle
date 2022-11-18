package com.kh.RestApi.dao;

import com.kh.RestApi.entity.MemberInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j // 로그포제이라고 읽음
class MemberRepositoryTest {
    // Component : bean에 객체를 등록하는 것(의존성 주입을 하는 것) => 이걸 해야 싱글톤 패턴이 됨 => heap영역으로 들어감
    @Autowired // 자동으로 연결(의존성 주입을 받는 것), 싱글톤 패턴
    // @Autowired를 쓰려면 bean에 등록한다는 과정이 필요함
    // bean에 등록된 객체는 어디서든지 가져다쓸 수 있음 => 등록되면 싱글톤 패턴 => Static 객체를 1개 만들기 때문에 거기서 정보를 지웠다가 썼다가 반복
    // 생성자로 집어넣으면 @Autowired 생략 가능
    // bean 객체를 만들어서 스프링이 heap영역에 등록
    // Spring 3대 특징(의존성 주입받기 @autowired, 제어의 역전inversion of controll(IoC), ?)
    MemberRepository memberRepository; // 의존성 주입을 받는 부분

    @Test
    @DisplayName("회원 가입 테스트")
    public void regMemberTest() {
        for(int i = 1; i <= 10; i++) {
            MemberInfo memberInfo = new MemberInfo(); // 이거는 의존성 주입하면 안되니까 new! 객체 생성해야 함
            memberInfo.setUserId("fds2236" + i);
            memberInfo.setPwd("fds2236");
            memberInfo.setName("test" + i);
            memberInfo.setEmail("fds2236@naver.com");
            memberInfo.setJoin(LocalDateTime.now()); // LocalDateTime.now() => 현재 시간 => sysdate와 같은 역할
            // memberRepository가 DB와 연결되는 기능
            memberRepository.save(memberInfo);
            log.error(memberInfo.toString());
        }
    }
}