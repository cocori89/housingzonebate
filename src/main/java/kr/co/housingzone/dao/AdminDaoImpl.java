package kr.co.housingzone.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.housingzone.controller.domain.AdminVO;

//DAO�� �پ���ϴ� ������̼�
// ������ ������ �����ϴ� Dao
@Repository
public class AdminDaoImpl implements AdminDao {

	// �ڵ����� ���� ��ü�� ã���ִ� ������̼�
	@Autowired
	private SqlSession sqlSession;

	// �α����� �ϴ� �޼ҵ� 
	@Override
	public AdminVO login(Map<String, String> map) {
		return sqlSession.selectOne("admin.login", map);
	}



}
