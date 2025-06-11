package com.example.demo.pojo.order.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
