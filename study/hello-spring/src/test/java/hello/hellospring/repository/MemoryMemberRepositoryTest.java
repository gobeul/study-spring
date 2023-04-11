package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("speing");

        repository.save(member);

        Member res = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(res);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        Member res = repository.findByName("spring1").get();
        assertThat(res).isEqualTo(member1);

    }

    @Test
    public void finAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> res = repository.findAll();
        assertThat(res.size()).isEqualTo(2);
    }

    public void clearStore() {
        repository.clearStore();
    }
}
