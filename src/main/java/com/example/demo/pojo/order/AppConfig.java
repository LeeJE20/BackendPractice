package com.example.demo.pojo.order;

import com.example.demo.pojo.order.discount.DiscountPolicy;
import com.example.demo.pojo.order.discount.FixDiscountPolicy;
import com.example.demo.pojo.order.member.MemberService;
import com.example.demo.pojo.order.member.MemberServiceImpl;
import com.example.demo.pojo.order.member.MemoryMemberRepository;
import com.example.demo.pojo.order.order.OrderService;
import com.example.demo.pojo.order.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
