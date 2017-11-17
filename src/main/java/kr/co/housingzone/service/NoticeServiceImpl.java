package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.housingzone.controller.domain.NoticeVO;
import kr.co.housingzone.dao.NoticeDao;

// service 역할을 할수 있도록하는 어노테이션 
// 해당 클래스가 service라는 것을 알려준다. 
// 그리고 서버 구동시 자동으로 생성될 수 있도록 한다. 
@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired // 자동을 같은 객체를 찾아서 연결해준다.
	private NoticeDao noticeDao;

	// 공지사항 등록
	@Override
	// form값을 받아야 하기 때문에 HttpServletRequest 객페를 사용 한다.
	public int insertNotice(HttpServletRequest request) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setSubject(request.getParameter("subject"));
		noticeVO.setContent(request.getParameter("content"));
		noticeVO.setWriter(request.getParameter("writer"));
		noticeVO.setIp(request.getRemoteAddr());
		return noticeDao.insertNotice(noticeVO);
	}

	// 공지 사항 리스트
	@Override
	public List<NoticeVO> getList() {
		return noticeDao.getList();
	}

	@Override
	public NoticeVO getContent(int no) {
		return noticeDao.getContent(no);
	}

	@Override
	public int deletenotice(int no) {
		return noticeDao.deletenotice(no);
	}


	@Override
	public int updateNotice(HttpServletRequest request) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNo(request.getParameter("no"));
		noticeVO.setSubject(request.getParameter("subject"));
		noticeVO.setContent(request.getParameter("content"));
		noticeVO.setWriter(request.getParameter("writer"));
		noticeVO.setIp(request.getRemoteAddr());
		return noticeDao.updateNotice(noticeVO);
	}
}
