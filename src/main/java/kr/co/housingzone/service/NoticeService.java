package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.housingzone.controller.domain.NoticeVO;

// �������� service �޼��带 �����ϴ� ���̴�. 
public interface NoticeService {
	//���� ��ȯ ���� int�� �༭ �������θ� �Ǵ��Ѵ�.
	public int insertNotice(HttpServletRequest request);// �������� ��� �޼���
	
	public List<NoticeVO> getList();//���������� ����Ʈ�� �޾ƿ��°�
	
	public NoticeVO getContent(int no);//�������� ������ ������ 
	
	public int deletenotice(int no);//��ȯ������ int �� �;��� �������θ� �˼� �ִ�. 
	
	public int updateNotice(HttpServletRequest request);// �������� ���� �޼���

	
}
