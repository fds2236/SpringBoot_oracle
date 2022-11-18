//package com.kh.RestApi.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api/v1/post-api")  // RequestMapping => 별 다른 설정이 없으면 HTTP의 모든 요청을 받음
//
//// GET API에서는 URL의 경로나 파리미터에 변수를 넣어 요청을 보냄
//// POST API에서는 저장하고자하는 리소스나 값을 HTTP바디(body)에 담아 서버에 전달
//// => 즉 URL이 GET API에 비해 비교적 간단
//
//public class PostController {
//
//    // 첫번째 방법 => @RequestMapping 자주 사용x
//    // get방식과 post방식 같음
//    // http://localhost:8111/api/v1/post-api/domain
//    @RequestMapping(value = "domain", method = RequestMethod.POST)
//    public String postEx() {
//        return "Hello Spring boot-POST";}
//
//    // 두번째 방법 => @RequestBody 자주 사용하는 방식
//    // POST형식의 데이터를 Body에서 추출
//    // 저장하고자하는 리소스나 값을 HTTP바디에 담기 때문에 포스트맨 이용시 Body-raw-json으로 돌려야 함
//    // Body 영역에 작성되는 값은 일반적으로 JSON형식으로 전송됨
//    // http://localhost:8111/api/v1/post-api/member
//    @PostMapping("/member")
//    public String postMember(@RequestBody Map<String, Object> postData) {
//        StringBuffer sb = new StringBuffer();
//        postData.entrySet().forEach(map -> {
//            sb.append(map.getKey() + " : " + map.getValue() + "\n");
//        });
//        return sb.toString();
//    }
//
//    // 로그인
//    @PostMapping("/Login2")
//    public ResponseEntity<Map<String, String>> memberLogin(@RequestBody Map<String, String> postData) {
//        String getId = postData.get("id");
//        String getPwd = postData.get("pwd");
//        Map<String, String> map = new HashMap<>();
//        map.put("result", "OK");
//        return new ResponseEntity(map, HttpStatus.OK); // 200
//       // return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
//    }
//}
