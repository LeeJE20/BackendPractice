package com.example.demo.pojo.order;

import com.example.demo.pojo.order.discount.RateDiscountPolicy;
import com.example.demo.pojo.order.member.MemberService;
import com.example.demo.pojo.order.member.MemberServiceImpl;
import com.example.demo.pojo.order.member.MemoryMemberRepository;
import com.example.demo.pojo.order.order.OrderService;
import com.example.demo.pojo.order.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
