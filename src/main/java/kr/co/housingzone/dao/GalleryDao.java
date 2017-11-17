package kr.co.housingzone.dao;

import java.util.List;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;

public interface GalleryDao {
	// ��� �޼���
	public int insertMainGallery(GallerymainVO gallerymainVO);//������ ���� ����ϱ� 
	public int selectMainNum();// ù��ϵ� ��ȣ �������� 
	public int insertPlanGallery(GalleryplanVO galleryplanVO);//������ ��յ� ����ϱ� 
	public int insertDetailGallery(GallerydetailVO gallerydetailVO);//������ �󼼻��� ����ϱ� 
	// ����Ʈ 
	public List<GallerymainVO> getGalleryList();
	
	// �� ����� ���� ���� �Ѱ� �ֱ� 
	public GallerymainVO getGalleryInfo(int num);
	// ����Ʈ -> ��� �ҷ� ����
	public List<GalleryplanVO> selectPlanGallery(int num);
	// ����Ʈ -> �󼼺���  �ҷ� ���� 
	public List<GallerydetailVO> selectDetailGallery(int num);
	
	
	//���� �κ�
	public int deleteMainGallery(int num);//���� ����
	public String deleteMainGalleryFile(int num);//���� ������ ���� ���� �̸� ���
	public List<String> deletePlanGalleryFile(int num);//��鵵 ������ ���� ���� �̸� ���
	public List<String> deleteDetailGalleryFile(int num);//������ ������ ���� ���� �̸� ���
	
	
	
	public int deletePlanGallery(int no);//��鵵 ����
	public String deletePlanGalleryFileSingle(int no);// ��鵵 ���� �����̸� ���
	
	public int deleteDetailGallery(int no);//������ ����
	public String deleteDetailGalleryFileSIngle(int no);// �� ���� ���� �����̸� ���
	

	
	
}
