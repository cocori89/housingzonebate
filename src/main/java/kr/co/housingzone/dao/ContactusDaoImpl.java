package kr.co.housingzone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.housingzone.controller.domain.ContactusVO;


@Repository
public class ContactusDaoImpl implements ContactusDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insertContactus(ContactusVO contactusVO) {
		return sqlSession.insert("contactus.insertContactus",contactusVO);
	}

	@Override
	public int deleteContactus(int num) {
		return sqlSession.delete("contactus.deleteContactus",num);
	}

	@Override
	public ContactusVO selectContactus(int num) {
		return sqlSession.selectOne("contactus.selectContactus",num);
	}

	@Override
	public List<ContactusVO> getList() {
		return sqlSession.selectList("contactus.selectList");
	}

}
