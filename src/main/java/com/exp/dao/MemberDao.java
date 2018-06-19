package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.Member;

public interface MemberDao  extends JpaRepository<Member, Integer>{
	public Member findById(int id);
}
