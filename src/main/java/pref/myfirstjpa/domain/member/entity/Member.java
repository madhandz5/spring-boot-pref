package pref.myfirstjpa.domain.member.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pref.myfirstjpa.domain.member.dto.SignUpForm;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName      : pref.myfirstjpa.domain.member.entity
 * fileName          : Member
 * author           : ryan
 * date             : 2022/10/21
 * description      :
 * =====================================================
 * DATE               AUTHOR                NOTE
 * -----------------------------------------------------
 * 2022/10/21          ryan       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;

    private LocalDateTime createdAt;

    public Member(SignUpForm form) {
        this.email = form.getEmail();
        this.password = form.getPassword();
    }

    public void completeSignUp() {
        setCreatedAt(LocalDateTime.now());
    }


    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
