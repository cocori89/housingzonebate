package kr.co.housingzone.dao;

import java.util.List;

import kr.co.housingzone.controller.domain.NoticeVO;

//DAO ��ü�� �����ϱ����� �̸� �������̽��� ������ش�. 
public interface NoticeDao {
	
	//���⼭ int ���� ������ �޴� ������ insert�� ���������� sql���� ���� ���θ� �˱� ���ؼ� �̴�. 
	//�׷��� ������ ���߿� ������ ���� �ȵ�� ���� ���� �˼��� ����. 
	//������ int ������ �����ؼ� �Ǵ��� �Ѵ�. ����̸� ����!!
	public int insertNotice(NoticeVO noticeVO);//�������� ��� DAO ����
	
	public List<NoticeVO> getList();//���������� ����Ʈ�� �޾ƿ��°�
	
	public NoticeVO getContent(int no);//�������� ������ ������ 
	
	public int deletenotice(int no);//��ȯ������ int �� �;��� �������θ� �˼� �ִ�. 

	public int updateNotice(NoticeVO noticeVO);//�������� ���� DAO ����
}
