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

	//������ ���� ���� ���
	@Override
	public int insertMainGallery(GallerymainVO gallerymainVO) {
		return sqlSession.insert("gallery.insertMainGallery", gallerymainVO);
	}
	
	//ù ��ϵ� ���� ȭ�� ��ȣ ���� ����
	@Override
	public int selectMainNum() {
		return sqlSession.selectOne("gallery.selectMainNum");
	}
	
	//������ ��鵵 ���� ���
	@Override
	public int insertPlanGallery(GalleryplanVO galleryplanVO) {
		return sqlSession.insert("gallery.insertPlanGallery", galleryplanVO);
	}

	// ������ �� ���� ���
	@Override
	public int insertDetailGallery(GallerydetailVO gallerydetailVO) {
		return sqlSession.insert("gallery.insertDetilGallery", gallerydetailVO);
	}

	// ������ ����ȭ�� ����Ʈ �ҷ� ���� 
	@Override
	public List<GallerymainVO> getGalleryList() {
		return sqlSession.selectList("gallery.selectGalleryList");
	}

	
	@Override
	public GallerymainVO getGalleryInfo(int num) {
		return sqlSession.selectOne("gallery.selectGalleryInfo", num);
	}
	
	//����Ʈ  -> ��鵵 �ҷ� ���� 
	@Override
	public List<GalleryplanVO> selectPlanGallery(int num) {
		return sqlSession.selectList("gallery.selectGalleryPlan",num);
	}

	//����Ʈ -> �� ���� �ҷ� ����
	@Override
	public List<GallerydetailVO> selectDetailGallery(int num) {
		return sqlSession.selectList("gallery.selectGalleryDetail",num);
	}

	// ���� ������ ����
	@Override
	public int deleteMainGallery(int num) {
		return sqlSession.delete("gallery.deleteGalleryMain",num);
	}
	//���� ������ ������ ���� ���� �̸� ���
	@Override
	public String deleteMainGalleryFile(int num) {
		return sqlSession.selectOne("gallery.selectGallerMainFile", num);
	}
	
	//���ο��� ������ ��鵵 ������ ���� �����̸� ���
	@Override
	public List<String> deletePlanGalleryFile(int num) {
		return sqlSession.selectList("gallery.selectGallerPlanFile", num);
	}
	
	//���ο��� ������ ������ ������ ���� �����̸� ���
	@Override
	public List<String> deleteDetailGalleryFile(int num) {
		return sqlSession.selectList("gallery.selectGallerDetailFile", num);
	}
	
	//������ ��鵵 ����
	@Override
	public int deletePlanGallery(int no) {
		return sqlSession.delete("gallery.deleteGalleryPlan",no);
	}
	//������ ��鵵 ���� ���
	@Override
	public String deletePlanGalleryFileSingle(int no) {
		return sqlSession.selectOne("gallery.selectGallerPlanFileSingle", no);
	}

	
	
	//������ ������ ����
	@Override
	public int deleteDetailGallery(int no) {
		return sqlSession.delete("gallery.deleteGalleryDetail",no);
	}
	//������ �� ���� ���� ���
	@Override
	public String deleteDetailGalleryFileSIngle(int no) {
		return sqlSession.selectOne("gallery.selectGallerDetailFileSingle", no);
	}





}
