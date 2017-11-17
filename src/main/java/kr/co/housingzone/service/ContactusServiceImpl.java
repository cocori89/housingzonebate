package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.housingzone.controller.domain.ContactusVO;
import kr.co.housingzone.controller.domain.NoticeVO;
import kr.co.housingzone.dao.ContactusDao;

@Service
public class ContactusServiceImpl implements ContactusService{

	@Autowired
	ContactusDao contactusDao;
	
	
	// Contact Us �Է�
	@Override
	public int insertContactus(HttpServletRequest request) {
		ContactusVO contactusVO = new ContactusVO();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		name = name.replaceAll("<", "&lt;");
		name = name.replaceAll(">", "&gt;");
		
		email = email.replaceAll("<", "&lt;");
		email = email.replaceAll(">", "&gt;");
		
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		
		
		contactusVO.setName(name);
		contactusVO.setEmail(email);
		contactusVO.setTitle(title);
		contactusVO.setContent(content);
		return contactusDao.insertContactus(contactusVO);
	}

	//���� ���� �ҷ� ���� 
	@Override
	public List<ContactusVO> getList() {
		return contactusDao.getList();
	}

	// ���� ���� �ڼ��Ѱ� ���� 
	@Override
	public ContactusVO selectContactus(int num) {
		return contactusDao.selectContactus(num);
	}

	//���� ���� ����
	@Override
	public int deleteContactus(int num) {
		return contactusDao.deleteContactus(num);
	}


}
