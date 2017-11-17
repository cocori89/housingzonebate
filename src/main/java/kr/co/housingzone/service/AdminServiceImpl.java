package kr.co.housingzone.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.housingzone.controller.domain.AdminVO;
import kr.co.housingzone.dao.AdminDao;

//서비스 객체로 해주는 어노테이션
@Service
public class AdminServiceImpl implements AdminService {

	// 자동으로 AdminDao 를 찾아준다. 
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public AdminVO login(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int re = -2;
		
		// 아이디 공백삭제와 소문자로 통일 시켜 주고
		// sql injection 방지  
		id = id.trim();
		id = id.toLowerCase();
		re = id.indexOf("'");
		if(re>=0){
			return null;
		}
		//패스 워드 검사
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
