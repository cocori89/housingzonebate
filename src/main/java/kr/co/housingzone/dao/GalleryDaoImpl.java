package kr.co.housingzone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;

@Repository
public class GalleryDaoImpl implements GalleryDao {

	@Autowired
	SqlSession sqlSession;

	//갤러리 메인 사진 등록
	@Override
	public int insertMainGallery(GallerymainVO gallerymainVO) {
		return sqlSession.insert("gallery.insertMainGallery", gallerymainVO);
	}
	
	//첫 등록된 메인 화면 번호 가져 오기
	@Override
	public int selectMainNum() {
		return sqlSession.selectOne("gallery.selectMainNum");
	}
	
	//갤러리 평면도 사진 등록
	@Override
	public int insertPlanGallery(GalleryplanVO galleryplanVO) {
		return sqlSession.insert("gallery.insertPlanGallery", galleryplanVO);
	}

	// 갤러리 상세 사진 등록
	@Override
	public int insertDetailGallery(GallerydetailVO gallerydetailVO) {
		return sqlSession.insert("gallery.insertDetilGallery", gallerydetailVO);
	}

	// 갤러리 메인화면 리스트 불러 오기 
	@Override
	public List<GallerymainVO> getGalleryList() {
		return sqlSession.selectList("gallery.selectGalleryList");
	}

	
	@Override
	public GallerymainVO getGalleryInfo(int num) {
		return sqlSession.selectOne("gallery.selectGalleryInfo", num);
	}
	
	//리스트  -> 평면도 불러 오기 
	@Override
	public List<GalleryplanVO> selectPlanGallery(int num) {
		return sqlSession.selectList("gallery.selectGalleryPlan",num);
	}

	//리스트 -> 상세 보기 불러 오기
	@Override
	public List<GallerydetailVO> selectDetailGallery(int num) {
		return sqlSession.selectList("gallery.selectGalleryDetail",num);
	}

	// 메인 갤러리 삭제
	@Override
	public int deleteMainGallery(int num) {
		return sqlSession.delete("gallery.deleteGalleryMain",num);
	}
	//메인 갤러리 삭제를 위한 파일 이름 얻기
	@Override
	public String deleteMainGalleryFile(int num) {
		return sqlSession.selectOne("gallery.selectGallerMainFile", num);
	}
	
	//메인에서 갤러리 평면도 삭제를 위한 파일이름 얻기
	@Override
	public List<String> deletePlanGalleryFile(int num) {
		return sqlSession.selectList("gallery.selectGallerPlanFile", num);
	}
	
	//메인에서 갤러리 상세정보 삭제를 위한 파일이름 얻기
	@Override
	public List<String> deleteDetailGalleryFile(int num) {
		return sqlSession.selectList("gallery.selectGallerDetailFile", num);
	}
	
	//갤러리 평면도 삭제
	@Override
	public int deletePlanGallery(int no) {
		return sqlSession.delete("gallery.deleteGalleryPlan",no);
	}
	//갤러리 평면도 파일 얻기
	@Override
	public String deletePlanGalleryFileSingle(int no) {
		return sqlSession.selectOne("gallery.selectGallerPlanFileSingle", no);
	}

	
	
	//갤러리 상세정보 삭제
	@Override
	public int deleteDetailGallery(int no) {
		return sqlSession.delete("gallery.deleteGalleryDetail",no);
	}
	//갤러리 상세 정보 파일 얻기
	@Override
	public String deleteDetailGalleryFileSIngle(int no) {
		return sqlSession.selectOne("gallery.selectGallerDetailFileSingle", no);
	}





}
