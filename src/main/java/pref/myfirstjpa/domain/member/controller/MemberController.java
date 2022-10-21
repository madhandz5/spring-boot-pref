package pref.myfirstjpa.domain.member.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pref.myfirstjpa.domain.member.dto.SignUpForm;
import pref.myfirstjpa.domain.member.entity.Member;
import pref.myfirstjpa.domain.member.service.MemberService;
import pref.myfirstjpa.domain.member.validator.SignUpFormValidator;

import javax.validation.Valid;
import java.util.List;

/**
 * packageName      : pref.myfirstjpa.domain.member.controller
 * fileName          : MemberController
 * author           : ryan
 * date             : 2022/10/21
 * description      :
 * =====================================================
 * DATE               AUTHOR                NOTE
 * -----------------------------------------------------
 * 2022/10/21          ryan       최초 생성
 */
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final SignUpFormValidator signUpFormValidator;

    @InitBinder(value = "signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }


    @GetMapping(value = "/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());
        return "member/sign-up";
    }

    @PostMapping(value = "/sign-up")
    public String signUp(@Valid SignUpForm sign, Errors errors) {
        if (errors.hasErrors()) {
            return "member/sign-up";
        }
        memberService.signUpProcess(sign);
        return "redirect:/";
    }

    @GetMapping(value = "/complete")
    public String complete(@RequestParam(value = "email") String email, RedirectAttributes attributes) {
        memberService.completeSignUp(email);
        attributes.addFlashAttribute("message", "인증 성공");
        return "redirect:/";
    }

    @GetMapping(value = "/member-list")
    public String getMemberList(Model model) {
        List<Member> memberList = memberService.getMemberList();
        model.addAttribute(memberList);
        return "member/member-list";
    }
}
