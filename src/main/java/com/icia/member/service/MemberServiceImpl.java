package com.icia.member.service;

import com.icia.member.dto.MemberDetailDTO;
import com.icia.member.dto.MemberSaveDTO;
import com.icia.member.entity.MemberEntity;
import com.icia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public MemberDetailDTO findById(Long memberId) {
        /*
            1. MemberRepository로 부터 해당 회원의 정보를 MemberEntity로 가져옴.
            2. MemberEntity를 MemberDatailDTO로 바꿔서 커트롤러로 리턴.
         */

        //1
        MemberEntity member = mr.findById(memberId).get();

        //2
        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(member);
        return memberDetailDTO;
        return null;
    }
}
