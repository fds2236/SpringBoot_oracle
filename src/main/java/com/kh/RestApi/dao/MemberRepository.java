package com.kh.RestApi.dao;

import com.kh.RestApi.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {
    // 로그인 : userId와 pwd가 같아야 함
    List<MemberInfo> findByUserIdAndPwd(String user, String pwd);
    // ID로 조회
    List<MemberInfo> findByUserId(String user);
}
