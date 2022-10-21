package pref.myfirstjpa.domain.member.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * packageName      : pref.myfirstjpa.domain.member.dto
 * fileName          : SignUpForm
 * author           : ryan
 * date             : 2022/10/21
 * description      :
 * =====================================================
 * DATE               AUTHOR                NOTE
 * -----------------------------------------------------
 * 2022/10/21          ryan       최초 생성
 */
@Data
public class SignUpForm {

    @Email(message = "이메일이 아닙니다.")
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
