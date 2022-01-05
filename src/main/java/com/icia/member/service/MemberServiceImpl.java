package com.icia.member.service;

import com.icia.member.dto.MemberSaveDTO;
import com.icia.member.entity.MemberEntity;
import com.icia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl  implements  MemberService{

    private final MemberRepository mr;

    @Override
    public void save(MemberSaveDTO membersaveDTO) {
        /*
            1. memberSaveDTO -> memberEntity에 옮기기
            2. memberRepository의 save메서드 호출 하면서  memberEntity 객체 전달
         */

        MemberEntity memberEntity = MemberEntity.saveMember(membersaveDTO);
        mr.save(memberEntity);

    }
}
