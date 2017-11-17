package kr.co.housingzone.dao;

import java.util.List;

import kr.co.housingzone.controller.domain.ContactusVO;

public interface ContactusDao {

	public int insertContactus(ContactusVO contactusVO );//고객이 견적 문의 
	public int deleteContactus(int num);//고객이 쓴거 삭제 
	public ContactusVO  selectContactus(int num);// 고객이 쓴거 보기 
	public List<ContactusVO> getList();//공지사항의 리스트를 받아오는것
	
	
}
