package com.example.demo.pojo.order.order;

import com.example.demo.pojo.order.member.Grade;
import com.example.demo.pojo.order.member.Member;
import com.example.demo.pojo.order.member.MemberService;
import com.example.demo.pojo.order.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
