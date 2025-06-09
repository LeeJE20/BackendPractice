package com.example.demo.pojo.order.discount;

import com.example.demo.pojo.order.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
