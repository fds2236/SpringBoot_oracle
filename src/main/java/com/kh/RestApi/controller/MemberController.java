package com.kh.RestApi.controller;//package com.kh.RestApi.controller;
//
//import com.kh.RestApi.service.MemberService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("api/v1/post-api")
//public class MemberController {
//    // 자동으로 클래스 이름 붙어다니게 만듦
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());
//
//    // MemberController와 MemberService 연결 관계 만들기
//    private MemberService memberService;
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    // 회원 조회
//    @GetMapping("/GetMemberParam")
//    public ResponseEntity<List<MemberVO>> memberList(@RequestParam String cmd, String id) {
//        LOGGER.info("회원 조회 아이디 : " + id);
//        List<MemberVO> list = memberService.getMemberList(id);
//            return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//    // 로그인
//    @PostMapping("/Login")
//    public Map<String, String> memberLogin(@RequestBody Map<String,String> loginData){
//        String getId = loginData.get("id");
//        String getPwd = loginData.get("pwd");
//        // System.out.println("Login Controller Call");
//        LOGGER.info("Login Controller Call");
//        Map<String, String> map = new HashMap<>();
//        return map;
//    }
//
//    // 아이디 중복체크
//    @PostMapping("/MemberCheck")
//    public ResponseEntity<Map<String, String>> MemberCheck(@RequestBody Map<String, String> chkData) {
//        String getId = chkData.get("id");
//        Map<String, String> map = new HashMap<>();
//            return new ResponseEntity(map, HttpStatus.OK);
//    }
//
//    // 회원가입
//    // @RequestBody를 무엇으로 받을 것이냐 Map으로 받을꺼고 키도 String, 값도 String
//    @PostMapping("/RegMember")
//    public ResponseEntity<Map<String, String>> memberRegister(@RequestBody Map<String, String> regData) {
//        String getId = regData.get("id");
//        String getPwd = regData.get("pwd");
//        String getName = regData.get("name");
//        String getMail = regData.get("mail");
//        Map<String, String> map = new HashMap<>();
//            return new ResponseEntity(map, HttpStatus.OK);
//    }
//
//    // 회원 탈퇴
//    @PostMapping("/MemberDelete")
//    public ResponseEntity<Map<String, String>> memberDelete(@RequestBody Map<String, String> delData) {
//        String getId = delData.get("id");
//        Map<String, String> map = new HashMap<>();
//            return new ResponseEntity(map, HttpStatus.OK);
//    }
//}

import com.kh.RestApi.dto.MemberDTO;
import com.kh.RestApi.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// 요청을 받고 응답을 해주는게 Controller
// View가 원래는 resources static 폴더 안에 html, css 등
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemberController {
    // Serice 로직 연결
    private MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService; // 생성자이기 때문에 autowired 안넣어도 됨
    }

    // 전체 회원 조회
    @GetMapping("/GetMember/list")
    // 리스트를 넘겨줌
    // 반환타입이 ResponseEntity! => JSON타입으로 날아감
    // memberList() => Mapping관계를 보고 servlet쪽으로 들어오면 Spring이 보내주는 것
    // @Param으로 안받아도 됨 왜? 전체조회기때문에 입력 파라미터값이 없음
    public ResponseEntity<List<MemberDTO>> memberList() {
        List<MemberDTO> list = memberService.getMemberList();
        return new ResponseEntity(list, HttpStatus.OK); // 안에 값을 넣어줘야하니까 new!!!
    }

    // 회원가입 서비스로직 호출
    // 회원가입에 대한 응답은 성공과 실패만 있으면 되니까 boolean
    @PostMapping("/RegMember")
    public ResponseEntity<Boolean> registerMember(@RequestBody Map<String, String> regData) {
        String userId = regData.get("user"); // 왼쪽은 엔터티 = 오른쪽은 디티오..???
        String pwd = regData.get("pwd");
        String name = regData.get("name");
        String mail = regData.get("mail");
        boolean result = memberService.regMember(userId, pwd, name, mail);
        // 지금 임의로 항상 true만 만듦
        if(result) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

    // 로그인 체크
    @PostMapping("/Login")
    public ResponseEntity<Boolean> memberLogin(@RequestBody Map<String, String> loginData) {
        String user = loginData.get("user");
        String pwd = loginData.get("pwd");
        boolean result = memberService.loginCheck(user, pwd);
        if(result) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

    // userId로 회원 조회하기
    @GetMapping("/GetMember")
    public ResponseEntity<List<MemberDTO>> memberList(@RequestParam String userId) {
        // 서비스 로직 호출
        List<MemberDTO> list = memberService.getMemberList(userId);
        return new ResponseEntity(list, HttpStatus.OK);
    }
}