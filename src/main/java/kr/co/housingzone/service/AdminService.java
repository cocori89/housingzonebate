package kr.co.housingzone.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.housingzone.controller.domain.AdminVO;

public interface AdminService {
	public AdminVO login(HttpServletRequest request);
}
