package com.example.demo.pojo.order.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.example.demo.pojo.order.member.Grade;
import com.example.demo.pojo.order.member.Member;

@DisplayName("RateDiscountPolicy 클래스의")
class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Nested
    class discount_메서드는 {

        @Nested
        class 만약_VIP_고객이라면 {

            @Test
            void 할인_10퍼센트가_적용되어야_한다() {
                // given
                Member member = new Member(1L, "memberVIP", Grade.VIP);

                // when
                int discountAmount = discountPolicy.discount(member, 10000);

                // then
                assertThat(discountAmount).isEqualTo(1000);
            }

        }

        @Nested
        class 만약_VIP_고객이_아니라면 {

            @Test
            void 할인_금액이_없다() {
                // given
                Member member = new Member(1L, "memberBASIC", Grade.BASIC);

                // when
                int discountAmount = discountPolicy.discount(member, 10000);

                // then
                assertThat(discountAmount).isEqualTo(0);
            }

        }
    }

}
