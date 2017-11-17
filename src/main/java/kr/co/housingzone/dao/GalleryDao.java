package kr.co.housingzone.dao;

import java.util.List;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;

public interface GalleryDao {
	// 등록 메서드
	public int insertMainGallery(GallerymainVO gallerymainVO);//갤러리 메인 등록하기 
	public int selectMainNum();// 첫등록된 번호 가져오기 
	public int insertPlanGallery(GalleryplanVO galleryplanVO);//갤러리 평먼도 등록하기 
	public int insertDetailGallery(GallerydetailVO gallerydetailVO);//갤러리 상세사진 등록하기 
	// 리스트 
	public List<GallerymainVO> getGalleryList();
	
	// 상세 보기시 메인 정보 넘겨 주기 
	public GallerymainVO getGalleryInfo(int num);
	// 리스트 -> 평명도 불러 오기
	public List<GalleryplanVO> selectPlanGallery(int num);
	// 리스트 -> 상세보기  불러 오기 
	public List<GallerydetailVO> selectDetailGallery(int num);
	
	
	//삭제 부분
	public int deleteMainGallery(int num);//메인 삭제
	public String deleteMainGalleryFile(int num);//메인 삭제를 위한 파일 이름 얻기
	public List<String> deletePlanGalleryFile(int num);//평면도 삭제를 위한 파일 이름 얻기
	public List<String> deleteDetailGalleryFile(int num);//상세정보 삭제를 위한 파일 이름 얻기
	
	
	
	public int deletePlanGallery(int no);//평면도 삭제
	public String deletePlanGalleryFileSingle(int no);// 평면도 삭제 파일이름 얻기
	
	public int deleteDetailGallery(int no);//상세정보 삭제
	public String deleteDetailGalleryFileSIngle(int no);// 상세 정보 삭제 파일이름 얻기
	

	
	
}
