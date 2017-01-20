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
		session.insert("users.insert", dto);
						// 세션 아이디 , 파라미터 값
	}

	@Override
	public boolean isValid(UsersDto dto) {
		UsersDto resultDto = session.selectOne("users.isValid", dto);
		if(resultDto == null){	// select된 정보가 없으면
			return false;		// 잘못된 아이디 또는 비밀번호
		}else{					// select된 정보가 있으면
			return true;		// 올바른 아이디와 비밀번호
		}
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
