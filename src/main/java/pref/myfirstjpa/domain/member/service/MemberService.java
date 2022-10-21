package pref.myfirstjpa.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pref.myfirstjpa.domain.member.dto.SignUpForm;
import pref.myfirstjpa.domain.member.entity.Member;
import pref.myfirstjpa.domain.member.repository.MemberRepository;

import java.util.List;

/**
 * packageName      : pref.myfirstjpa.domain.member.service
 * fileName          : MemberService
 * author           : ryan
 * date             : 2022/10/21
 * description      :
 * =====================================================
 * DATE               AUTHOR                NOTE
 * -----------------------------------------------------
 * 2022/10/21          ryan       최초 생성
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signUpProcess(SignUpForm sign) {
        Member member = new Member(sign);
        memberRepository.save(member);
    }


    @Transactional
    public void completeSignUp(String email) {
        Member byEmail = memberRepository.findByEmail(email);
        byEmail.completeSignUp();
        memberRepository.save(byEmail);
    }

    public List<Member> getMemberList() {
        return memberRepository.findAll();
    }
}