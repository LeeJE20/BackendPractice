package com.example.demo.pojo.order.order;

import com.example.demo.pojo.order.AppConfig;
import com.example.demo.pojo.order.member.Grade;
import com.example.demo.pojo.order.member.Member;
import com.example.demo.pojo.order.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
