package kr.co.housingzone.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.housingzone.controller.domain.GallerydetailVO;
import kr.co.housingzone.controller.domain.GallerymainVO;
import kr.co.housingzone.controller.domain.GalleryplanVO;
import kr.co.housingzone.dao.GalleryDao;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	GalleryDao galleryDao;
	//-------------------
	// ������ ���� ���� ��� (���� ����)
	@Override
	public int insertMainGallery(MultipartHttpServletRequest request) {
		GallerymainVO gallerymainVO = new GallerymainVO();
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		// �ؿ��� ������������ �޼���� �޾� ����
		String mainfilename;
		String fileExtension; //���� Ȯ���� ���� ���� 
		
		// ���� �޾��� ��ü 
		MultipartFile mf = request.getFile("mainfile");
		
		// ����Ʈ ���� �̸� ���
		mainfilename = mf.getOriginalFilename();
		
		//���� ���ε��� Ȯ���� ��ȿ�� üũ ---------- ����
		//Ȯ���� �̱�
		fileExtension = mainfilename.substring(mainfilename.indexOf(".")+1, mainfilename.length());
		// Ȯ���� �ҹ��ڷ� �ٲٱ�
		fileExtension = fileExtension.toLowerCase();
		// ���� Ȯ���ڰ� �̹��� ���� �ƴ��� �Ǵ� 
		if(fileExtension.equals("jpg")||fileExtension.equals("tiff")||
				fileExtension.equals("psd")||fileExtension.equals("png")||
				fileExtension.equals("bmp")||fileExtension.equals("gif")){
			System.out.println(mainfilename+ "��(��) �������� �̹��� �����Դϴ�. ");
		}else {
			System.out.println(mainfilename+ "��(��) ���輺�ִ� ���� �̹��� �Դϴ�.  ");
			return -1;
		}
		//���� ���ε��� Ȯ���� ��ȿ�� üũ ---------- ��
		
		
		
		//���� ��� ���ϱ� 
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/main/");
		// ���� ��� + ���� �̸� 
		String saveFile = path+"/"+ mainfilename;
		
		try {
			mf.transferTo(new File(saveFile));
		} catch (Exception e) {
			System.out.println("���� ���� ���� ���" +  e);
		}
		
		// Dao �� ���� ���� DTO �� ��� �ش�. 
		gallerymainVO.setSubject(subject);
		gallerymainVO.setWriter(writer);
		gallerymainVO.setMainfilename(mainfilename);
		
		return galleryDao.insertMainGallery(gallerymainVO);
	}

	// ���� ��� �� ���� num ���� �� ���� ����
	@Override
	public int selectMainNum() {
		return galleryDao.selectMainNum();
	}
	
	
	//--------------------
	// ������ ��鵵 ���� ��� (���� ����)int ���� �Ѿ�;� �ϱ� ������ ������ ���� �Ϸ� �Ŀ� �ۼ��ؾ���  
	@Override
	public int insertPlanGallery(MultipartHttpServletRequest request, int num) {
		//������ �޾��ִ� ��ü ����
		List<MultipartFile> fileList = request.getFiles("planfile");
		//Ȯ���� ��ȿ�� üũ�� ���� ���� ����
		String fileExtension;
		
		// ����� ���� ��� ��� 
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/plan/");
		
			for(MultipartFile mf : fileList){
				GalleryplanVO galleryplanVO= new GalleryplanVO();
				// ���� �̸� ���
				String planfilename = mf.getOriginalFilename();
				//���� ���ε��� Ȯ���� ��ȿ�� üũ ---------- ����
				//Ȯ���� ��� 
				fileExtension = planfilename.substring(planfilename.indexOf('.')+1,planfilename.length());
				//Ȯ���� �ҹ��ڷ� ��ȯ
				fileExtension = fileExtension.toLowerCase();
				// ���� Ȯ���ڰ� �̹��� ���� �ƴ��� �Ǵ� 
				if(fileExtension.equals("jpg")||fileExtension.equals("tiff")||
						fileExtension.equals("psd")||fileExtension.equals("png")||
						fileExtension.equals("bmp")||fileExtension.equals("gif")){
					System.out.println(planfilename+ "��(��) �������� �̹��� �����Դϴ�. ");
				}else {
					System.out.println(planfilename+ "��(��) ���輺�ִ� ���� �̹��� �Դϴ�.  ");
					return -1;
				}
				
				
				
				//���� ���ε��� Ȯ���� ��ȿ�� üũ ---------- ��
				
				// ���� ���� ��� + ���� �̸� 
				String saveFilePath = path+"/"+planfilename;
				
				try {
					mf.transferTo(new File(saveFilePath));
				} catch (Exception e) {
					System.out.println("��鵵 ���� ����"+e);
				}
				
				// Dao �� �Ѱ��� DTO �� ����
				galleryplanVO.setNum(num);
				galleryplanVO.setPlanfilename(planfilename);
				galleryDao.insertPlanGallery(galleryplanVO);
			}
			return 100; // ������ 100���� 
	}

	//--------------
	// ������ �� ���� ���� ��� 
	@Override
	public int insertDetailGallery(MultipartHttpServletRequest request, int num) {
		
		// ���� �޾��ִ� ��ü 
		List<MultipartFile> fileList = request.getFiles("detailfile");
		//Ȯ���� ��ȿ�� üũ�� ���� ���� ����
		String fileExtension;
		
		
		//���� ��� 
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/detail/");
		
		System.out.println("1");
		for(MultipartFile mf : fileList){
			GallerydetailVO gallerydetailVO = new GallerydetailVO();
			//���� �̸� 
			String detailfilename = mf.getOriginalFilename();
			//���� ���ε��� Ȯ���� ��ȿ�� üũ ---------- ����
			//Ȯ���� ��� 
			fileExtension = detailfilename.substring(detailfilename.indexOf('.')+1,detailfilename.length());
			//Ȯ���� �ҹ��ڷ� ��ȯ
			fileExtension = fileExtension.toLowerCase();
			// ���� Ȯ���ڰ� �̹��� ���� �ƴ��� �Ǵ� 
			if(fileExtension.equals("jpg")||fileExtension.equals("tiff")||
					fileExtension.equals("psd")||fileExtension.equals("png")||
					fileExtension.equals("bmp")||fileExtension.equals("gif")){
				System.out.println(detailfilename+ "��(��) �������� �̹��� �����Դϴ�. ");
			}else {
				System.out.println(detailfilename+ "��(��) ���輺�ִ� ���� �̹��� �Դϴ�.  ");
				return -1;
			}
			
			
			
			// ������ + ���� �̸� 
			String saveFilePath = path +"/"+ detailfilename;
			System.out.println("2");
			try {
				mf.transferTo(new File(saveFilePath));
			} catch (Exception e) {
				System.out.println("�缼���� ���� ���� " + e);
			}
			
			// Dao ���� �Ѱ� �� �� ���� 
			gallerydetailVO.setNum(num);
			gallerydetailVO.setDetailfilename(detailfilename);
			galleryDao.insertDetailGallery(gallerydetailVO);
		}
		return 200;
	}

	//--------------------------
	//����Ʈ �ҷ����� 
	@Override
	public List<GallerymainVO> getGalleryList() {
		return galleryDao.getGalleryList();
	}

	
	@Override
	public GallerymainVO getGalleryInfo(int num) {
		return galleryDao.getGalleryInfo(num);
	}
	//����Ʈ -> ��鵵 �ҷ� ����
	@Override
	public List<GalleryplanVO> selectPlanGallery(int num) {
		return galleryDao.selectPlanGallery(num);
	}
	
	//����Ʈ -> �� ���� �ҷ� ���� 
	@Override
	public List<GallerydetailVO> selectDetailGallery(int num) {
		return galleryDao.selectDetailGallery(num);
	}

	
	//���� ������ ����
	@Override
	public int deleteMainGallery(int num, HttpServletRequest request) {
		

		//���� ������ ������ ��鵵 �����̸��� ���ϱ� 
		List<String> planFileNames = galleryDao.deletePlanGalleryFile(num);
		// ���� ������ ������ ��鵵�� �����. 
		for(String planFileName : planFileNames){// �ҷ� �� ������ �� ���� �´�. 
			//���+�����̸� �� ��ģ��. 
			String planPath = request.getSession().getServletContext().getRealPath("/resources/gallery/plan/"+planFileName);
			// ���� ��ü ������ �Ѵ�. ������ ��Ʈ�� �ϱ� ����
			File planFile = new File(planPath);
			try {
				//������ �����Ѵ�. 
				planFile.delete();
			} catch (Exception e) {
			}
			
		}

		//���� ������ ������ �� ���� ���� �̸��� ���ϱ� 
		List<String> detailFileNames = galleryDao.deleteDetailGalleryFile(num);
		// ���� �� ���� ��ŭ �� �����. 
		for(String detailFileName : detailFileNames){
			// ��� + ���� �̸�
			String detailPath = request.getSession().getServletContext().getRealPath("/resources/gallery/detail/"+detailFileName);
			// ������ �����ϱ� ���� ���� ��ü ����
			File detailFile = new File(detailPath);
			
			try {
				//���� ����
				detailFile.delete();
			} catch (Exception e) {
			}
			
		}
		
		// ���� ������ �������� ������ �������� ��鵵�� �� ���� ��θ� ���Ҽ� �֤�. 
		//���� �̸� ��� 
		String mainFilaName = galleryDao.deleteMainGalleryFile(num);
		
		//���� ������ ���� ���� ��� ���
		String mianPath = request.getSession().getServletContext().getRealPath("/resources/gallery/main/"+mainFilaName);
		
		//���� ��ü�� ������ ��ü�� �����. 
		File mainFile = new File(mianPath);
		try {
			// ���� �� �����Ѵ�. 
			mainFile.delete();
		} catch (Exception e) {
		}
		
		
		return galleryDao.deleteMainGallery(num);
	}

	//������ ��鵵 ����
	@Override
	public int deletePlanGallery(int no,HttpServletRequest request) {
	
		//���� �̸� ��� 
		String filaName = galleryDao.deletePlanGalleryFileSingle(no);
				System.out.println(no);
		//���� ������ ���� ���� ��� ���
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/plan/"+filaName);
		System.out.println(filaName);
				
		//���� ��ü�� ������ ��ü�� �����. 
		File planFile = new File(path);
				
		try {
			// ���� �� �����Ѵ�. 
			planFile.delete();
		} catch (Exception e) {
		}
		
		return galleryDao.deletePlanGallery(no);
	}

	//������ �� ���� ����
	@Override
	public int deleteDetailGallery(int no,HttpServletRequest request) {
		//���� �̸� ��� 
		String filaName = galleryDao.deleteDetailGalleryFileSIngle(no);
		System.out.println(no);
		System.out.println(filaName);
		
		//���� ������ ���� ���� ��� ���
		String path = request.getSession().getServletContext().getRealPath("/resources/gallery/detail/"+filaName);
		
		//���� ��ü�� ������ ��ü�� �����. 
		File detailFile = new File(path);
		
		try {
			// ���� �� �����Ѵ�. 
			detailFile.delete();
		} catch (Exception e) {
		}
		return galleryDao.deleteDetailGallery(no);
	}

	

}

