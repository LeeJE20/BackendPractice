package com.example.demo.pojo.order.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.example.demo.pojo.order.member.Grade;
import com.example.demo.pojo.order.member.Member;
import com.example.demo.pojo.order.member.MemberService;
import com.example.demo.pojo.order.member.MemberServiceImpl;

@DisplayName("OrderService 클래스의")
public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Nested
    class createOrder_메서드는 {

        @Nested
        class 만약_VIP_고객이라면 {

            @Test
            @DisplayName("1000원을 할인한다")
            void createOrder() {
                Long memberId = 1L;
                Member member = new Member(memberId, "memberA", Grade.VIP);
                memberService.join(member);

                Order order = orderService.createOrder(memberId, "itemA", 10000);

                Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
            }
        }

    }
}
