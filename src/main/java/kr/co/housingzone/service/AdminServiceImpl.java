package kr.co.housingzone.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.housingzone.controller.domain.AdminVO;
import kr.co.housingzone.dao.AdminDao;

//���� ��ü�� ���ִ� ������̼�
@Service
public class AdminServiceImpl implements AdminService {

	// �ڵ����� AdminDao �� ã���ش�. 
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public AdminVO login(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int re = -2;
		
		// ���̵� ��������� �ҹ��ڷ� ���� ���� �ְ�
		// sql injection ����  
		id = id.trim();
		id = id.toLowerCase();
		re = id.indexOf("'");
		if(re>=0){
			return null;
		}
		//�н� ���� �˻�
		password = password.trim();
		password = password.toLowerCase();
		re = password.indexOf("'");
		if(re>=0){
			return null;
		}
		
		
		Map<String , String> map =  new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		
		return adminDao.login(map);
	}

}
