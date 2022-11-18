//package com.kh.RestApi.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("api/v1/get-api") // RequestMapping => 별 다른 설정이 없으면 HTTP의 모든 요청을 받음
//
//public class GetController {
//    // 첫번째 방법 => @RequestMapping 자주 사용x
//    // get방식과 post방식 같음
//    // http://localhost:8111/api/v1/get-api/hello
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String getHello() {
//        return "Hello Spring boot-GET";
//    }
//
//    // 두번째 방법 => @GetMapping 매개변수가 없는 GET 메서드 구현
//    // http://localhost:8111/api/v1/get-api/name
//    @GetMapping(value = "/name")
//    public String getName() {
//        return "Name : 천지훈";
//    }
//
//    // 세 번째 방법 => @GetMapping 매개변수를 받는 GET 메서드 구현(@PathVariable, @RequestParam)
//    // 실무에서 자주 사용
//
//    // @PathVariable : URL 자체에 값을 담아 요청
//    // http://localhost:8111/api/v1/get-api/variable1/곰돌이사육사
//    @GetMapping("/variable1/{variable}")
//    public String getVariable1(@PathVariable("variable") String var) {
//        return "당신의 이름은 " + var;
//    }
//
//    // @RequestParam : URL에 쿼리형식으로 값을 전달
//    // 우리가 써야할 Get방식!!!(select할 때)
//    // 키와 값으로 구성된 형태로 전달하는 방법
//    // GET 요청을 구현할 때 URL 경로에 쿼리 형식으로 값을 전달하는 방식
//    // URI에서 첫번째는 ?{키}={값}, 두번째부터는 &{키}={값}
//    // 첫번째 RequestParam은 ?, 두번째 RequestParam은 &
//    // http://localhost:8111/api/v1/get-api/request1/?name="안유진"&email="yj@gmail.com"&company="kh"
//    @GetMapping("/request1")
//    public String getRequestParam(
//        @RequestParam String name,
//        @RequestParam String email,
//        @RequestParam String company) {
//        return "이름 : " + name + "이메일 : " + email + "회사 : " + company;
//    }
//
//    // @RestController와 @GetMapping을 사용한 JSON
//    // 자주 사용할 방식
//    // http://localhost:8111/api/v1/get-api/member
//    @GetMapping("/member")
//    // @ResponseBody => 이 객체를 제이슨형태로 날려주는 것(@RestController 어노테이션이 있다면 생략해도 이미 자동으로 알고있음)
//    public List<Map<String, Object>> getMembers() {
//        List<Map<String, Object>>members = new ArrayList<>();
//        for(int i = 1; i <= 20; i++) {
//            Map<String, Object> member = new HashMap<>();
//            member.put("id", i);
//            member.put("name", i + "번 개발자");
//            member.put("age", 10 + i);
//            members.add(member);
//        }
//        return members;
//    }
//
//    // DTO : 값을 전달하기 위한 용도(화면에 보여주기위한 정보)
//    // VO와 DTO는 크게 구분하지 않아도 되지만 DB와는 확실하게 구분해야 함
//    // VO와 DTO는 명명규칙이지 문법이 아님
//    // db관리하기 위한 정보(DAO)와 사용자가 필요한 정보(VO, DTO)는 다름!
//    // 즉, 데이터베이스의 1:1매핑관계가 될 수도 있고 안될 수도 있음
//    // => 모델이 없고 컨트롤러만 있어서 이렇게 쓴 것 일뿐
//    // http://localhost:8111/api/v1/get-api/memberVO
//    @GetMapping("/memberVO")
//    public List<MemberVO> getMemberVO() {
//        List<MemberVO> list = new ArrayList<>();
//        for(int i = 0; i < 10; i++) {
//            MemberVO vo = new MemberVO();
//            vo.setId("jks2024");
//            vo.setPwd("sphb8250");
//            vo.setName("곰돌이사육사");
//            vo.setEmail("jks2024@gmail.com");
//            list.add(vo);
//        }
//        return list;
//    }
//
//    // @ResponseEntry : 예외 상황에 대해 좀 더 세밀한 제어가 필요한 경우 사용
//    // return 값에서 ResponseEntity객체 생성
//    @GetMapping("/memberList")
//    public ResponseEntity<List<MemberVO>> listMember() {
//        List<MemberVO> list = new ArrayList<>();
//        for(int i = 0; i < 10; i++) {
//            MemberVO vo = new MemberVO();
//            vo.setId("fds2236");
//            vo.setPwd("fds2236!!!");
//            vo.setName("실버벨");
//            vo.setEmail("fds2236@gmail.com");
//            list.add(vo);
//        }
//         return new ResponseEntity(list, HttpStatus.OK);
//       // return new ResponseEntity(null, HttpStatus.BAD_REQUEST); // 에러인 상황을 알려줄 때
//    }
//}