package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.housingzone.controller.domain.NoticeVO;
import kr.co.housingzone.dao.NoticeDao;

// service ������ �Ҽ� �ֵ����ϴ� ������̼� 
// �ش� Ŭ������ service��� ���� �˷��ش�. 
// �׸��� ���� ������ �ڵ����� ������ �� �ֵ��� �Ѵ�. 
@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired // �ڵ��� ���� ��ü�� ã�Ƽ� �������ش�.
	private NoticeDao noticeDao;

	// �������� ���
	@Override
	// form���� �޾ƾ� �ϱ� ������ HttpServletRequest ���並 ��� �Ѵ�.
	public int insertNotice(HttpServletRequest request) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setSubject(request.getParameter("subject"));
		noticeVO.setContent(request.getParameter("content"));
		noticeVO.setWriter(request.getParameter("writer"));
		noticeVO.setIp(request.getRemoteAddr());
		return noticeDao.insertNotice(noticeVO);
	}

	// ���� ���� ����Ʈ
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
