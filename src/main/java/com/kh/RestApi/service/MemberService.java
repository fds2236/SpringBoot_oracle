//package com.kh.RestApi.service;
//
//import com.kh.RestApi.dao.MemberRepository;
//import com.kh.RestApi.entity.MemberInfo;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;
//
//@Service
//public class MemberService {
//    // MemberRepository와 Service 연결 부분
//    private MemberRepository memberRepository;
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository; // 의존성 주입함
//    }
//
//    // 회원 정보
//    public List<MemberVO> getMemberList(String id) {
//        List<MemberVO> list = new ArrayList<>();
//        List<MemberInfo> getList = memberRepository.findAll();
//        for(MemberInfo e : getList){
//            LOGGER.info("ID : " + e.getId());
//            LOGGER.info("PWD : " + e.getPwd());
//            LOGGER.info("NAME : " + e.getName());
//            MemberVO memberVO = new MemberVO();
//            memberVO.setId(e.getId());
//            memberVO.setPwd(e.getPwd());
//
//            list.add(memberVO);
//        }
//        return list;
//    }
//}

package com.kh.RestApi.service;

import com.kh.RestApi.dao.MemberRepository;
import com.kh.RestApi.dto.MemberDTO;
import com.kh.RestApi.entity.MemberInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j // 로그을 찍어주기 위한 부분
@Service // 의존성 등록 => 하나의 객체Singleton으로 만듦 => 왜? 메모리 낭비를 줄이기 위하여
// 왜 @Component라고 안 써? 가독성을 높이기위해 @Service라고 쓰는 것 뿐 역할은 똑같다!
public class MemberService {
    // 레파지토리 가지고와야 함
    // 코드 3줄 => 의존성 주입, 연결
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 연결고리
    }

    // 컨트롤러가 필요한 정보를 넘겨줘야 함
    public List<MemberDTO> getMemberList() {
        List<MemberDTO> memberDTOS = new ArrayList<>(); // 회원정보에 대한 전체 조회, 프엔이 요청하는 정보가 똑같다면 필요없는 코드
        List<MemberInfo> memberInfoList = memberRepository.findAll(); // 엔티티와 똑같은 db모양으로 담아야 함
        // 향상된 for문 : 배열요소를 자동으로 순회
        for(MemberInfo e : memberInfoList) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setUser(e.getUserId()); // 값을 담음
            memberDTO.setPwd(e.getPwd());
            memberDTO.setName(e.getName());
            memberDTO.setEmail(e.getEmail());
            memberDTO.setGrade("VIP"); // grade는 db테이블에 없었음 => 조인관계 이용(지금은 임시로 VIP넣음)
            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }

    // userId로 조회해서 리스트로 받아옴
    public List<MemberDTO> getMemberList(String user) {
        List<MemberDTO> memberDTOS = new ArrayList<>();
        List<MemberInfo> memberInfoList = memberRepository.findAll(); // 엔티티와 똑같은 db모양으로 담아야 함
        // 향상된 for문 : 배열요소를 자동으로 순회
        for(MemberInfo e : memberInfoList) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setUser(e.getUserId()); // 값을 담음
            memberDTO.setPwd(e.getPwd());
            memberDTO.setName(e.getName());
            memberDTO.setEmail(e.getEmail());
            memberDTO.setGrade("VIP"); // grade는 db테이블에 없었음 => 조인관계 이용(지금은 임시로 VIP넣음)
            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }


    // 회원 가입
    public boolean regMember(String userId, String pwd, String name, String mail) {
        MemberInfo memberInfo = new MemberInfo(); // 객체 생성
        // 엔터티에 있는 것들
        memberInfo.setUserId(userId);
        memberInfo.setPwd(pwd);
        memberInfo.setName(name);
        memberInfo.setEmail(mail);
        memberInfo.setJoin(LocalDateTime.now());
        MemberInfo rst = memberRepository.save(memberInfo);
        log.error(rst.toString());
        return true;
    }

    // 로그인
    public boolean loginCheck(String user, String pwd) {
     List<MemberInfo> memberInfoList = memberRepository.findByUserIdAndPwd(user, pwd);
     for(MemberInfo e : memberInfoList) {
         return true;
     }
     return false;
    }
}
