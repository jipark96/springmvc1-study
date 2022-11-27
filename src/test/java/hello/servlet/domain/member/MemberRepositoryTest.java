package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    //[테스트가 끝날 때 마다 초기화]
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }
    //[저장 확인]
    @Test
    void save() {
        //given
        Member member = new Member("jihyun", 27);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember); // 찾아온 멤버는 저장된 멤버랑 같아야 한다.
    }

    //[모든걸 조회하는 테스트]
    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();

        //then

        assertThat(result.size()).isEqualTo(2); //alt + enter , 개수 확인
        assertThat(result).contains(member1, member2); // 개체 있는지 확인
    }
}
