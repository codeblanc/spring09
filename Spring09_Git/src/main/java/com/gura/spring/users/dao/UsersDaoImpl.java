package com.gura.spring.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring.users.dto.UsersDto;

//component 스캔시 bean 으로 만들기 위한 어노테이션
@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		
		
	}

	@Override
	public boolean isValid(UsersDto dto) {
		
		return false;
	}

	@Override
	public void update(UsersDto dto) {
		
		
	}

	@Override
	public void delete(String id) {
		
		
	}

	@Override
	public boolean canUseId(String id) {
		String selectedId = session.selectOne("users.isExistId", id);
		if(selectedId==null){	// 없으면
			return true;		// 사용가능한 아이디이다.
		}else{
			return false;
		}
	}

}
