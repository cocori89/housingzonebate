package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.housingzone.controller.domain.NoticeVO;

// 공지사항 service 메서드를 선언하는 곳이다. 
public interface NoticeService {
	//역시 반환 값은 int를 줘서 성공여부를 판단한다.
	public int insertNotice(HttpServletRequest request);// 공지사항 등록 메서드
	
	public List<NoticeVO> getList();//공지사항의 리스트를 받아오는것
	
	public NoticeVO getContent(int no);//공지사항 상세정보 얻어오기 
	
	public int deletenotice(int no);//반환값으로 int 가 와야지 성공여부를 알수 있다. 
	
	public int updateNotice(HttpServletRequest request);// 공지사항 수정 메서드

	
}
