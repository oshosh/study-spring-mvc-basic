package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

  MemberRepository memberRepository = MemberRepository.getInstance();

  @AfterEach
  void afterEach(){
    memberRepository.clearStore();
  }

  @Test
  void save(){
    //given
    Member member = new Member("hello", 20);

    //when
    Member saveMember = memberRepository.save(member);

    //then
    Member findMember = memberRepository.findById(saveMember.getId());
    assertThat(findMember).isEqualTo(saveMember);
  }

  @Test
  void findAll(){
    //given
    Member member1 = new Member("member1", 20);
    Member member2 = new Member("member2", 30);
    Member member3 = new Member("member3", 40);

    //when
    memberRepository.save(member1);
    memberRepository.save(member2);
    memberRepository.save(member3);

    //then
    List<Member> all = memberRepository.findAll();

    assertThat(all.size()).isEqualTo(3);

    assertThat(all).contains(member1, member2, member3);
  }
}