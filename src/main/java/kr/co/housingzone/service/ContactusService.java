package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.housingzone.controller.domain.ContactusVO;
import kr.co.housingzone.controller.domain.NoticeVO;

public interface ContactusService {
	//���� ��ȯ ���� int�� �༭ �������θ� �Ǵ��Ѵ�.
	public int insertContactus(HttpServletRequest request);// �� ���� ��� �޼���
	
	public List<ContactusVO> getList();//���� ����Ʈ�� �޾ƿ��°�
	
	public ContactusVO selectContactus(int num);//���� ������ ������ 
	
	public int deleteContactus(int num);//��ȯ������ int �� �;��� �������θ� �˼� �ִ�. 
	

}
