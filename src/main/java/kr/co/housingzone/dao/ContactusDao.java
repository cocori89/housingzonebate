package kr.co.housingzone.dao;

import java.util.List;

import kr.co.housingzone.controller.domain.ContactusVO;

public interface ContactusDao {

	public int insertContactus(ContactusVO contactusVO );//���� ���� ���� 
	public int deleteContactus(int num);//���� ���� ���� 
	public ContactusVO  selectContactus(int num);// ���� ���� ���� 
	public List<ContactusVO> getList();//���������� ����Ʈ�� �޾ƿ��°�
	
	
}
