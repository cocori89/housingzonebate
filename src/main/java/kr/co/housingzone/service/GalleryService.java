package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;

public interface GalleryService {
	
	//입력 폼
	public int insertMainGallery(MultipartHttpServletRequest request);//갤러리 메인 등록하기 
	public int selectMainNum();// 첫등록된 번호 가져오기 
	public int insertPlanGallery(MultipartHttpServletRequest request, int num);//갤러리 평먼도 등록하기 
	public int insertDetailGallery(MultipartHttpServletRequest request, int num);//갤러리 상세사진 등록하기 
	
	//메인 갤러리 리스트 불러오기
	public List<GallerymainVO> getGalleryList();
	
	// 상세 보기시 메인 정보 넘겨 주기 
	public GallerymainVO getGalleryInfo(int num);
	// 리스트 -> 평명도 불러 오기
	public List<GalleryplanVO> selectPlanGallery(int num);
	// 리스트 -> 상세보기  불러 오기 
	public List<GallerydetailVO> selectDetailGallery(int num);
	
	//삭제 부분
	public int deleteMainGallery(int num,HttpServletRequest request);//메인 삭제
	public int deletePlanGallery(int no,HttpServletRequest request);//평면도 삭제
	public int deleteDetailGallery(int no,HttpServletRequest request);//상세정보 삭제
	
	
}
