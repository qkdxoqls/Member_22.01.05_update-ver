package com.icia.member;


import com.icia.member.dto.MemberDetailDTO;
import com.icia.member.dto.MemberSaveDTO;
import com.icia.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberTest {
    /*
        MemberServiceImpl.save() 메서드가 잘 동작하는지 테스트
        
        회원가입 테스트
        save.html 에서 회원정보 입력 후 가입 클릭
        DB 확인
     */
    @Autowired
    private MemberService ms;

    @Test
    @DisplayName("회원가입 테스트")
    public void memberSaveTest() {
        MemberSaveDTO memberSaveDTO = new MemberSaveDTO();
        memberSaveDTO.setMemberEmail("회원이메일1");
        memberSaveDTO.setMemberPassword("회원비번1");
        memberSaveDTO.setMemberName("회원이름1");

        ms.save(memberSaveDTO);
    }

    @Test
    @Transactional // 테스트 시작할떄 새로운 트랜젝션 시작
    @Rollback   // 테슽, 종료후 롤백 수행
    @DisplayName("회원 조회 리스트")
    public void memberDetailTest() {
        // given : 테스트 조건 설정
            // 1. 새로운 회원을 등록하고 해당회원의 번호(member_id)를 가져옴.
        // 1-1 테스트용 데이터 객체 생성
        MemberSaveDTO memberSaveDTO = new MemberSaveDTO("조회용회원이메일", "조회용회원비밀번호", "조회용회원이름");
        // 1-2 테스트용 데이터를 DB에 저장 하고 member_id를 가져옴
        Long memberId = ms.save(memberSaveDTO);
        // when : 테스트 수행
            // 2. 위에서 가져온 회원번호를 가지고 조회 기능 수행
        MemberDetailDTO findMember = ms.findById(memberId);
        // then : 테스트 결과 검증
            // 3. 1번에서 가입한 회원의 정보와 2번의 에서 조회한 회원의 정보가 일치하면 테스트 총과 일치하지 않으면 테스트 실패
        // memberSaveDTO의 이메일값과 findMember의 이메일값이 일치하는지 확인.
        assertThat(memberSaveDTO.getMemberEmail()).isEqualTo(findMember.getMemberEmail());


    }

}
