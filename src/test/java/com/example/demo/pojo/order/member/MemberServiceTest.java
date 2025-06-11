package com.example.demo.pojo.order.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.example.demo.pojo.order.AppConfig;

@DisplayName("MemberService 클래스의")
public class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Nested
    class Discribe_join_메서드는 {

        @Nested
        class Context_만약_아이디가_중복되지_않은_멤버_저장할_경우 {

            @Test
            void 회원_정보를_저장한다() {
                // given
                Member memberA = new Member(1L, "memberA", Grade.VIP);

                // when
                memberService.join(memberA);
                Member findMember = memberService.findMember(memberA.getId());

                // then
                Assertions.assertThat(findMember).isEqualTo(memberA);
            }
        }
    }
}
