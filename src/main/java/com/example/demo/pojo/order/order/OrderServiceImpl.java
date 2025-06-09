package com.example.demo.pojo.order.order;

import com.example.demo.pojo.order.discount.DiscountPolicy;
import com.example.demo.pojo.order.discount.FixDiscountPolicy;
import com.example.demo.pojo.order.member.Member;
import com.example.demo.pojo.order.member.MemberRepository;
import com.example.demo.pojo.order.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
