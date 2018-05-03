package com.example.demo.dao;

import com.example.demo.domain.Member;

public interface MemberRepository {
	
	Member findByNameNoCache(String name);
	Member findByNameCache(String name);
	void refresh(String name);
	
}
