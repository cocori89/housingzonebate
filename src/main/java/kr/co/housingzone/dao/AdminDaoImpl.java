package kr.co.housingzone.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.housingzone.controller.domain.AdminVO;

//DAO에 붙어야하는 어노테이션
// 관리자 계정을 관리하는 Dao
@Repository
public class AdminDaoImpl implements AdminDao {

	// 자동으로 같은 객체를 찾아주는 어노테이션
	@Autowired
	private SqlSession sqlSession;

	// 로그인을 하는 메소드 
	@Override
	public AdminVO login(Map<String, String> map) {
		return sqlSession.selectOne("admin.login", map);
	}



}
