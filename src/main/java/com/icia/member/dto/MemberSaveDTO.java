package com.icia.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor // 모든필드를 매개변수로 하는 생성자
@NoArgsConstructor // 기본생성자
public class MemberSaveDTO {
    @NotBlank(message = "이메일은 필수요 동무")
    private String memberEmail;
    @NotBlank
    @Length(min = 2, max = 8, message = "2글자에서 8글자 이내로 입력하시오 동무")
    private String memberPassword;
    private String memberName;

}
