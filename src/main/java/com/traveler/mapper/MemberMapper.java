package com.traveler.mapper;

import java.util.List;
import java.util.Map;

import com.traveler.model.Member;

public interface MemberMapper {
	
	List<Member> loginselectAll();
	Member selectByIdAndPassword(Map<String, Object> idAndPassword);

	
}
