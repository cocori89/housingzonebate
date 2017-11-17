package kr.co.housingzone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;

public interface GalleryService {
	
	//�Է� ��
	public int insertMainGallery(MultipartHttpServletRequest request);//������ ���� ����ϱ� 
	public int selectMainNum();// ù��ϵ� ��ȣ �������� 
	public int insertPlanGallery(MultipartHttpServletRequest request, int num);//������ ��յ� ����ϱ� 
	public int insertDetailGallery(MultipartHttpServletRequest request, int num);//������ �󼼻��� ����ϱ� 
	
	//���� ������ ����Ʈ �ҷ�����
	public List<GallerymainVO> getGalleryList();
	
	// �� ����� ���� ���� �Ѱ� �ֱ� 
	public GallerymainVO getGalleryInfo(int num);
	// ����Ʈ -> ��� �ҷ� ����
	public List<GalleryplanVO> selectPlanGallery(int num);
	// ����Ʈ -> �󼼺���  �ҷ� ���� 
	public List<GallerydetailVO> selectDetailGallery(int num);
	
	//���� �κ�
	public int deleteMainGallery(int num,HttpServletRequest request);//���� ����
	public int deletePlanGallery(int no,HttpServletRequest request);//��鵵 ����
	public int deleteDetailGallery(int no,HttpServletRequest request);//������ ����
	
	
}
