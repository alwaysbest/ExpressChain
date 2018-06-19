package com.exp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.MemberDao;
import com.exp.model.Member;
import com.exp.service.MemberService;
@Service
public class MemberImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;

	@Override
	public Member getMember(int id) {
		// TODO Auto-generated method stub
		return memberDao.findById(id);
	}
	
}
