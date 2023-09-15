package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private MemberServiceImpl() {}

    private static MemberService memberService = new MemberServiceImpl();

    public static MemberService getMemberService() {
        return memberService;
    }

	@Override
	public void registerMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberDao().registerMember(memberDto);
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		MemberDto login = MemberDaoImpl.getMemberDao().login(userId, userPass);
		return login;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberDao().modifyMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) {
		MemberDaoImpl.getMemberDao().deleteMember(userId);
	}

}
