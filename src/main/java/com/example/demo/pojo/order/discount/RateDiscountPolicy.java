package com.example.demo.pojo.order.discount;

import com.example.demo.pojo.order.member.Grade;
import com.example.demo.pojo.order.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    // 한글
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }

}
