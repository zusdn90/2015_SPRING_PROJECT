package com.traveler.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.traveler.mapper.AdminMapper;
import com.traveler.mapper.MemberMapper;
import com.traveler.model.Member;
import com.traveler.util.AdminPagination;
import com.traveler.util.Pagination;

public class MemberDao {
	AdminMapper adminMapper;
	MemberMapper memberMapper;
	
	public void setMemberMapper(MemberMapper mapper) {
		this.memberMapper = mapper;
	}

	public void setAdminMapper(AdminMapper mapper) {
		this.adminMapper = mapper;
	}

	public int selectCount() {
		return adminMapper.selectCount();
	}

	public List<Member> selectAll() {
		return adminMapper.selectAll();
	}
	
	public List<Member> loginselectAll() {
		return null;
	}
	
	public List<Member> selectAdminPage(AdminPagination pagination) {
		return adminMapper.selectAdminPage(pagination);
	}
	
	public Member selectByNum(int num) {
		return adminMapper.selectByNum(num);
	}
	
	public int insert(Member member) {
		int rtn = adminMapper.insert(member);
		
		return member.getNum();
	}
	
	public int update(Member member) {
		return adminMapper.update(member);
	}
	
	public int deleteByNum(int num) {
		return adminMapper.deleteByNum(num);
	}

	public Member selectByIdAndPassword(String id, String password) {
		Map<String, Object> idAndPassword = new HashMap<String, Object>();
		idAndPassword.put("id", id);
		idAndPassword.put("password", password);

		return memberMapper.selectByIdAndPassword(idAndPassword);
	}
	
	public int chkId(String ckid) {
		return adminMapper.chkId(ckid);
	}
}