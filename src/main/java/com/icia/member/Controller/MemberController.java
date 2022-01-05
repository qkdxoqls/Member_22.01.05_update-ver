package com.icia.member.Controller;

import com.icia.member.dto.MemberLoginDTO;
import com.icia.member.dto.MemberSaveDTO;
import com.icia.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor // final 키워드가 붙은 필드만 생성자를 만들어줌
public class MemberController {

    private  final MemberService ms;

    @GetMapping("save")
    public String saveFrom(Model model) {
        model.addAttribute("member", new MemberSaveDTO());
        return "member/save";
    }


    @PostMapping("save")
    public String save(@Validated @ModelAttribute("member") MemberSaveDTO membersaveDTO, BindingResult bindingResult){
        System.out.println("memberSaveDTO = " + membersaveDTO);

        if (bindingResult.hasErrors()) {
            return "member/save";
        }

        ms.save(membersaveDTO);

        return "redirect:/member/login";
    }

    @GetMapping("login")
    public String loginFrom(Model model) {
        model.addAttribute("login", new MemberLoginDTO());
        return "member/login";
    }

    @PostMapping("login")
    public String login(@Validated @ModelAttribute("login") MemberLoginDTO memberloginDTO, BindingResult bindingResult){
        System.out.println("memberLoginDTO = " + memberloginDTO);

        if (bindingResult.hasErrors()) {
            return "member/login";
        }

        return "redirect:/member/findAll";
    }

}
