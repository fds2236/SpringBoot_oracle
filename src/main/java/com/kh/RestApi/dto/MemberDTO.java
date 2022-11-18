package com.kh.RestApi.dto;

import lombok.Getter;
import lombok.Setter;
// DTO와 VO 둘 중 하나 만들기
// servlet은 주로 VO라고 함
// spring은 주로 DTO라고 함
// 내부에 필드값에 직접적으로 접근하면 안되니까 Getter, Setter
@Getter
@Setter
public class MemberDTO {
    // 왜 id는 없어?? id는 회원 생성 순으로 붙인 숫자인데 그걸 전달할 필요는 없으니까!
    private String user;
    private String pwd; // pwd는 왜? 사용자에게 보여줄 필요는 없지만 전달은 해야함
    private String name;
    private String email;
    private String grade;
}
