package pref.myfirstjpa.domain.member.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pref.myfirstjpa.domain.member.dto.SignUpForm;
import pref.myfirstjpa.domain.member.repository.MemberRepository;

/**
 * packageName      : pref.myfirstjpa.domain.member.validator
 * fileName          : SignUpFormValidator
 * author           : ryan
 * date             : 2022/10/21
 * description      :
 * =====================================================
 * DATE               AUTHOR                NOTE
 * -----------------------------------------------------
 * 2022/10/21          ryan       최초 생성
 */
@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

    private final MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignUpForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpForm form = (SignUpForm) target;

        if (memberRepository.existsByEmail(form.getEmail())) {
            errors.rejectValue("email", "invalid.email", "이미 사용중인 이메일입니다.");
        }

    }
}
