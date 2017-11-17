package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.housingzone.controller.domain.ContactusVO;
import kr.co.housingzone.controller.domain.NoticeVO;

public interface ContactusService {
	//역시 반환 값은 int를 줘서 성공여부를 판단한다.
	public int insertContactus(HttpServletRequest request);// 고객 견적 등록 메서드
	
	public List<ContactusVO> getList();//견적 리스트를 받아오는것
	
	public ContactusVO selectContactus(int num);//견적 상세정보 얻어오기 
	
	public int deleteContactus(int num);//반환값으로 int 가 와야지 성공여부를 알수 있다. 
	

}
