package com.icia.member.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class MemberLoginDTO {
    @NotBlank(message = "이메일은 필수요 동무")
    private String memberEmail;
    @NotBlank
    @Length(min = 2, max = 8, message = "2자에서 8자로 입력하라시라요")
    private String memberPassword;
    private String memberName;
}
