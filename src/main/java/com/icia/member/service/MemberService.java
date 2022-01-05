package com.icia.member.service;

import com.icia.member.dto.MemberDetailDTO;
import com.icia.member.dto.MemberSaveDTO;

public interface MemberService {
    void save(MemberSaveDTO membersaveDTO);

    MemberDetailDTO findById(Long memberId);
}
