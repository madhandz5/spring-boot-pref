package pref.myfirstjpa.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pref.myfirstjpa.domain.member.entity.Member;

/**
 * packageName      : pref.myfirstjpa.domain.member.repository
 * fileName          : MemberRepository
 * author           : ryan
 * date             : 2022/10/21
 * description      :
 * =====================================================
 * DATE               AUTHOR                NOTE
 * -----------------------------------------------------
 * 2022/10/21          ryan       최초 생성
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    boolean existsByEmail(String email);
}
