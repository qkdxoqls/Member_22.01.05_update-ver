package com.icia.member.repository;

import com.icia.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository <해당Entity클래스이름, PK타입>
// JpaRepository 상속받아 쓸때는 @Repository 어노테이션이 필요없음
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
