package kr.co.housingzone.dao;

import java.util.Map;

import kr.co.housingzone.controller.domain.AdminVO;

public interface AdminDao {

	public AdminVO login(Map<String, String> map);
}
